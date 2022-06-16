package xyz.lemone.apihub.support.sqlparse.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.lemone.apihub.support.sqlparse.expression.function.AvgFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.CountFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.FormatDateFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.FormatNumberFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.Function;
import xyz.lemone.apihub.support.sqlparse.expression.function.GetFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.JsonFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.MaxFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.MinFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.OrderFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.ParameterFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.ParameterIsEmptyFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.SumFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.DateFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.DayFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.MonthFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.WeekFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.YearFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.AbsFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.CeilFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ChnFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.CosFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ExpFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.FloorFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.Log10Function;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.LogFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.MedianFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ModeFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.PowFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.RandomFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.RoundFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.SinFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.SqrtFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.StdevpFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.TanFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.VaraFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.IndexOfFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.LengthFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.LowerFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.ReplaceFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.SubstringFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.TrimFunction;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.UpperFunction;
import xyz.lemone.apihub.support.sqlparse.expression.manager.ExpressionFunctions;

import java.util.List;

/**
 * SqlParseAutoConfig.
 *
 * @author lemon
 * @since 0.0.1
 */
@Configuration
public class SqlParseAutoConfig {

    /**
     * 方法表达式管理器.
     *
     * @param functions 托管的方法
     * @return ExpressionFunctions
     */
    @Bean
    public ExpressionFunctions expressionFunctionManager(List<Function> functions) {
        ExpressionFunctions manager = new ExpressionFunctions();
        manager.registerFunctions(functions);
        return manager;
    }


    /**
     * 参数方法.
     *
     * @return parameterFunction
     */
    @Bean
    public ParameterFunction parameterFunction() {
        return new ParameterFunction();
    }

    @Bean
    public ParameterIsEmptyFunction parameterIsEmptyFunction() {
        return new ParameterIsEmptyFunction();
    }

    @Bean
    public AvgFunction avgFunction() {
        return new AvgFunction();
    }

    @Bean
    public JsonFunction jsonFunction() {
        return new JsonFunction();
    }

    @Bean
    public OrderFunction orderFunction() {
        return new OrderFunction();
    }

    @Bean
    public GetFunction getFunction() {
        return new GetFunction();
    }

    @Bean
    public CountFunction countFunction() {
        return new CountFunction();
    }

    @Bean
    public SumFunction sumFunction() {
        return new SumFunction();
    }

    @Bean
    public MaxFunction maxFunction() {
        return new MaxFunction();
    }

    @Bean
    public MinFunction minFunction() {
        return new MinFunction();
    }

    @Bean
    public FormatNumberFunction formatNumberFunction() {
        return new FormatNumberFunction();
    }

    @Bean
    public FormatDateFunction formatDateFunction() {
        return new FormatDateFunction();
    }

    @Bean
    public IndexOfFunction indexOfFunction() {
        return new IndexOfFunction();
    }

    @Bean
    public LengthFunction lengthFunction() {
        return new LengthFunction();
    }

    @Bean
    public LowerFunction lowerFunction() {
        return new LowerFunction();
    }

    @Bean
    public ReplaceFunction replaceFunction() {
        return new ReplaceFunction();
    }

    @Bean
    public SubstringFunction substringFunction() {
        return new SubstringFunction();
    }

    @Bean
    public TrimFunction trimFunction() {
        return new TrimFunction();
    }

    @Bean
    public UpperFunction upperFunction() {
        return new UpperFunction();
    }

    @Bean
    public DateFunction dateFunction() {
        return new DateFunction();
    }

    @Bean
    public DayFunction dayFunction() {
        return new DayFunction();
    }

    @Bean
    public MonthFunction monthFunction() {
        return new MonthFunction();
    }

    @Bean
    public WeekFunction weekFunction() {
        return new WeekFunction();
    }

    @Bean
    public YearFunction yearFunction() {
        return new YearFunction();
    }

    @Bean
    public AbsFunction absFunction() {
        return new AbsFunction();
    }

    @Bean
    public CeilFunction ceilFunction() {
        return new CeilFunction();
    }

    @Bean
    public CosFunction cosFunction() {
        return new CosFunction();
    }

    @Bean
    public ExpFunction expFunction() {
        return new ExpFunction();
    }

    @Bean
    public FloorFunction floorFunction() {
        return new FloorFunction();
    }

    @Bean
    public Log10Function log10Function() {
        return new Log10Function();
    }

    @Bean
    public LogFunction logFunction() {
        return new LogFunction();
    }

    @Bean
    public MedianFunction medianFunction() {
        return new MedianFunction();
    }

    @Bean
    public ModeFunction modeFunction() {
        return new ModeFunction();
    }

    @Bean
    public PowFunction powFunction() {
        return new PowFunction();
    }

    @Bean
    public RandomFunction randomFunction() {
        return new RandomFunction();
    }

    @Bean
    public RoundFunction roundFunction() {
        return new RoundFunction();
    }

    @Bean
    public SinFunction sinFunction() {
        return new SinFunction();
    }

    @Bean
    public ChnFunction chnFunction() {
        return new ChnFunction();
    }

    @Bean
    public SqrtFunction sqrtFunction() {
        return new SqrtFunction();
    }

    @Bean
    public StdevpFunction stdevpFunction() {
        return new StdevpFunction();
    }

    @Bean
    public TanFunction tanFunction() {
        return new TanFunction();
    }

    @Bean
    public VaraFunction varaFunction() {
        return new VaraFunction();
    }

}
