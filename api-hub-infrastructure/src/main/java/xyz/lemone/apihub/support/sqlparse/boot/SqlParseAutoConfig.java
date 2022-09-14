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
import xyz.lemone.apihub.support.sqlparse.expression.function.date.DateFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.DayFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.MonthFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.WeekFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.date.YearFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.AbsFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.CeilFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ChnFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.CosFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ExpFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.FloorFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.Log10FunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.LogFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.MedianFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.ModeFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.PowFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.RandomFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.RoundFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.SinFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.SqrtFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.StdevpFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.TanFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.math.VaraFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.IndexOfFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.LengthFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.LowerFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.ReplaceFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.SubstringFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.TrimFunctionBase;
import xyz.lemone.apihub.support.sqlparse.expression.function.string.UpperFunctionBase;
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
    public IndexOfFunctionBase indexOfFunction() {
        return new IndexOfFunctionBase();
    }

    @Bean
    public LengthFunctionBase lengthFunction() {
        return new LengthFunctionBase();
    }

    @Bean
    public LowerFunctionBase lowerFunction() {
        return new LowerFunctionBase();
    }

    @Bean
    public ReplaceFunctionBase replaceFunction() {
        return new ReplaceFunctionBase();
    }

    @Bean
    public SubstringFunctionBase substringFunction() {
        return new SubstringFunctionBase();
    }

    @Bean
    public TrimFunctionBase trimFunction() {
        return new TrimFunctionBase();
    }

    @Bean
    public UpperFunctionBase upperFunction() {
        return new UpperFunctionBase();
    }

    @Bean
    public DateFunctionBase dateFunction() {
        return new DateFunctionBase();
    }

    @Bean
    public DayFunctionBase dayFunction() {
        return new DayFunctionBase();
    }

    @Bean
    public MonthFunctionBase monthFunction() {
        return new MonthFunctionBase();
    }

    @Bean
    public WeekFunctionBase weekFunction() {
        return new WeekFunctionBase();
    }

    @Bean
    public YearFunctionBase yearFunction() {
        return new YearFunctionBase();
    }

    @Bean
    public AbsFunctionBase absFunction() {
        return new AbsFunctionBase();
    }

    @Bean
    public CeilFunctionBase ceilFunction() {
        return new CeilFunctionBase();
    }

    @Bean
    public CosFunctionBase cosFunction() {
        return new CosFunctionBase();
    }

    @Bean
    public ExpFunctionBase expFunction() {
        return new ExpFunctionBase();
    }

    @Bean
    public FloorFunctionBase floorFunction() {
        return new FloorFunctionBase();
    }

    @Bean
    public Log10FunctionBase log10Function() {
        return new Log10FunctionBase();
    }

    @Bean
    public LogFunctionBase logFunction() {
        return new LogFunctionBase();
    }

    @Bean
    public MedianFunctionBase medianFunction() {
        return new MedianFunctionBase();
    }

    @Bean
    public ModeFunctionBase modeFunction() {
        return new ModeFunctionBase();
    }

    @Bean
    public PowFunctionBase powFunction() {
        return new PowFunctionBase();
    }

    @Bean
    public RandomFunctionBase randomFunction() {
        return new RandomFunctionBase();
    }

    @Bean
    public RoundFunctionBase roundFunction() {
        return new RoundFunctionBase();
    }

    @Bean
    public SinFunctionBase sinFunction() {
        return new SinFunctionBase();
    }

    @Bean
    public ChnFunctionBase chnFunction() {
        return new ChnFunctionBase();
    }

    @Bean
    public SqrtFunctionBase sqrtFunction() {
        return new SqrtFunctionBase();
    }

    @Bean
    public StdevpFunctionBase stdevpFunction() {
        return new StdevpFunctionBase();
    }

    @Bean
    public TanFunctionBase tanFunction() {
        return new TanFunctionBase();
    }

    @Bean
    public VaraFunctionBase varaFunction() {
        return new VaraFunctionBase();
    }

}
