package xyz.lemone.apihub.support.sqlparse.expression.function.math;

import xyz.lemone.apihub.support.sqlparse.context.Context;
import xyz.lemone.apihub.support.sqlparse.expression.function.Functions;
import xyz.lemone.apihub.support.sqlparse.expression.model.data.ExpressionData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 中文人民币.
 *
 * @author lemon
 */
public class ChnMoneyFunction extends MathFunction {
    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private static final String[] CN_UPPER_UNIT = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟"};

    private static final String CN_NEGATIVE = "负";

    private static final int NUMBER_PRECISION = 2;

    private static final String CN_ZERO = "零";

    private static final String CN_FULL = "整";

    @Override
    public Object execute(List<ExpressionData<?>> dataList, Context context) {
        BigDecimal data = buildBigDecimal(dataList);
        return numberToR(data);
    }

    @Override
    public String name() {
        return Functions.RMB;
    }

    private static String numberToR(BigDecimal numberData) {
        StringBuilder sb = new StringBuilder();
        int signum = numberData.signum();
        if (signum == 0) {
            return CN_ZERO;
        }
        long number = numberData.movePointRight(NUMBER_PRECISION).setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_UNIT[numIndex]);
                }
                getZero = true;
            }
            number = number / 10;
            ++numIndex;
        }
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }
}
