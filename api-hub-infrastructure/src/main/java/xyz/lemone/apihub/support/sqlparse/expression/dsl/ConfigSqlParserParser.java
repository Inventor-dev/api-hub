// Generated from ConfigSqlParser.g4 by ANTLR 4.10.1

package xyz.lemone.apihub.support.sqlparse.expression.dsl;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigSqlParserParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, Cell = 14, ArithmeticOperator = 15,
            LogicalOperator = 16, ORDER = 17, BOOLEAN = 18, COLON = 19, COMMA = 20, NULL = 21,
            LeftParen = 22, RightParen = 23, STRING = 24, AND = 25, OR = 26, INTEGER = 27, NUMBER = 28,
            EXCLAMATION = 29, EXP = 30, Identifier = 31, LETTER = 32, Char = 33, DIGIT = 34, WS = 35,
            NL = 36, Operator = 37;
    public static final int
            RULE_entry = 0, RULE_expression = 1, RULE_exprComposite = 2, RULE_ternaryExpr = 3,
            RULE_caseExpr = 4, RULE_casePart = 5, RULE_ifExpr = 6, RULE_ifPart = 7,
            RULE_elseIfPart = 8, RULE_elsePart = 9, RULE_block = 10, RULE_exprBlock = 11,
            RULE_returnExpr = 12, RULE_expr = 13, RULE_ifCondition = 14, RULE_variableAssign = 15,
            RULE_item = 16, RULE_unit = 17, RULE_variable = 18, RULE_dataset = 19,
            RULE_function = 20, RULE_functionParameter = 21, RULE_set = 22, RULE_conditions = 23,
            RULE_condition = 24, RULE_property = 25, RULE_currentValue = 26, RULE_simpleValue = 27,
            RULE_join = 28, RULE_aggregate = 29;

    private static String[] makeRuleNames() {
        return new String[]{
                "entry", "expression", "exprComposite", "ternaryExpr", "caseExpr", "casePart",
                "ifExpr", "ifPart", "elseIfPart", "elsePart", "block", "exprBlock", "returnExpr",
                "expr", "ifCondition", "variableAssign", "item", "unit", "variable",
                "dataset", "function", "functionParameter", "set", "conditions", "condition",
                "property", "currentValue", "simpleValue", "join", "aggregate"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'?'", "'case'", "'{'", "'}'", "'if'", "'else'", "'return'", "';'",
                "'var'", "'='", "'.'", "'to'", "'@'", null, null, null, null, null, "':'",
                "','", "'null'", "'('", "')'", null, null, null, null, null, "'!'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, "Cell", "ArithmeticOperator", "LogicalOperator", "ORDER",
                "BOOLEAN", "COLON", "COMMA", "NULL", "LeftParen", "RightParen", "STRING",
                "AND", "OR", "INTEGER", "NUMBER", "EXCLAMATION", "EXP", "Identifier",
                "LETTER", "Char", "DIGIT", "WS", "NL", "Operator"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "ConfigSqlParser.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public ConfigSqlParserParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class EntryContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(ConfigSqlParserParser.EOF, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EntryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_entry;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterEntry(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitEntry(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitEntry(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EntryContext entry() throws RecognitionException {
        EntryContext _localctx = new EntryContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_entry);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(60);
                            expression();
                        }
                    }
                    setState(63);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << BOOLEAN) | (1L << NULL) | (1L << LeftParen) | (1L << STRING) | (1L << INTEGER) | (1L << NUMBER) | (1L << Identifier))) != 0));
                setState(65);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExprCompositeContext exprComposite() {
            return getRuleContext(ExprCompositeContext.class, 0);
        }

        public IfExprContext ifExpr() {
            return getRuleContext(IfExprContext.class, 0);
        }

        public CaseExprContext caseExpr() {
            return getRuleContext(CaseExprContext.class, 0);
        }

        public ReturnExprContext returnExpr() {
            return getRuleContext(ReturnExprContext.class, 0);
        }

        public VariableAssignContext variableAssign() {
            return getRuleContext(VariableAssignContext.class, 0);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_expression);
        try {
            setState(72);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(67);
                    exprComposite(0);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(68);
                    ifExpr();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(69);
                    caseExpr();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(70);
                    returnExpr();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(71);
                    variableAssign();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCompositeContext extends ParserRuleContext {
        public ExprCompositeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprComposite;
        }

        public ExprCompositeContext() {
        }

        public void copyFrom(ExprCompositeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ComplexExprCompositeContext extends ExprCompositeContext {
        public List<ExprCompositeContext> exprComposite() {
            return getRuleContexts(ExprCompositeContext.class);
        }

        public ExprCompositeContext exprComposite(int i) {
            return getRuleContext(ExprCompositeContext.class, i);
        }

        public TerminalNode Operator() {
            return getToken(ConfigSqlParserParser.Operator, 0);
        }

        public ComplexExprCompositeContext(ExprCompositeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterComplexExprComposite(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitComplexExprComposite(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitComplexExprComposite(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SingleExprCompositeContext extends ExprCompositeContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public SingleExprCompositeContext(ExprCompositeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterSingleExprComposite(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitSingleExprComposite(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitSingleExprComposite(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParenExprCompositeContext extends ExprCompositeContext {
        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public ExprCompositeContext exprComposite() {
            return getRuleContext(ExprCompositeContext.class, 0);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public ParenExprCompositeContext(ExprCompositeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterParenExprComposite(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitParenExprComposite(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitParenExprComposite(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TernaryExprCompositeContext extends ExprCompositeContext {
        public TernaryExprContext ternaryExpr() {
            return getRuleContext(TernaryExprContext.class, 0);
        }

        public TernaryExprCompositeContext(ExprCompositeContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterTernaryExprComposite(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitTernaryExprComposite(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitTernaryExprComposite(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCompositeContext exprComposite() throws RecognitionException {
        return exprComposite(0);
    }

    private ExprCompositeContext exprComposite(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprCompositeContext _localctx = new ExprCompositeContext(_ctx, _parentState);
        ExprCompositeContext _prevctx = _localctx;
        int _startState = 4;
        enterRecursionRule(_localctx, 4, RULE_exprComposite, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(81);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        _localctx = new SingleExprCompositeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(75);
                        expr();
                    }
                    break;
                    case 2: {
                        _localctx = new TernaryExprCompositeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(76);
                        ternaryExpr();
                    }
                    break;
                    case 3: {
                        _localctx = new ParenExprCompositeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(77);
                        match(LeftParen);
                        setState(78);
                        exprComposite(0);
                        setState(79);
                        match(RightParen);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(88);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ComplexExprCompositeContext(new ExprCompositeContext(_parentctx, _parentState));
                                pushNewRecursionContext(_localctx, _startState, RULE_exprComposite);
                                setState(83);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(84);
                                match(Operator);
                                setState(85);
                                exprComposite(2);
                            }
                        }
                    }
                    setState(90);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class TernaryExprContext extends ParserRuleContext {
        public List<IfConditionContext> ifCondition() {
            return getRuleContexts(IfConditionContext.class);
        }

        public IfConditionContext ifCondition(int i) {
            return getRuleContext(IfConditionContext.class, i);
        }

        public List<BlockContext> block() {
            return getRuleContexts(BlockContext.class);
        }

        public BlockContext block(int i) {
            return getRuleContext(BlockContext.class, i);
        }

        public TerminalNode COLON() {
            return getToken(ConfigSqlParserParser.COLON, 0);
        }

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        public TernaryExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ternaryExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterTernaryExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitTernaryExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitTernaryExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TernaryExprContext ternaryExpr() throws RecognitionException {
        TernaryExprContext _localctx = new TernaryExprContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_ternaryExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(91);
                ifCondition();
                setState(97);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND || _la == OR) {
                    {
                        {
                            setState(92);
                            join();
                            setState(93);
                            ifCondition();
                        }
                    }
                    setState(99);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(100);
                match(T__0);
                setState(101);
                block();
                setState(102);
                match(COLON);
                setState(103);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CaseExprContext extends ParserRuleContext {
        public List<CasePartContext> casePart() {
            return getRuleContexts(CasePartContext.class);
        }

        public CasePartContext casePart(int i) {
            return getRuleContext(CasePartContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ConfigSqlParserParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ConfigSqlParserParser.COMMA, i);
        }

        public CaseExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_caseExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterCaseExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitCaseExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitCaseExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CaseExprContext caseExpr() throws RecognitionException {
        CaseExprContext _localctx = new CaseExprContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_caseExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(105);
                match(T__1);
                setState(106);
                match(T__2);
                setState(107);
                casePart();
                setState(112);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(108);
                            match(COMMA);
                            setState(109);
                            casePart();
                        }
                    }
                    setState(114);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(115);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CasePartContext extends ParserRuleContext {
        public List<IfConditionContext> ifCondition() {
            return getRuleContexts(IfConditionContext.class);
        }

        public IfConditionContext ifCondition(int i) {
            return getRuleContext(IfConditionContext.class, i);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        public TerminalNode COLON() {
            return getToken(ConfigSqlParserParser.COLON, 0);
        }

        public CasePartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_casePart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterCasePart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitCasePart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitCasePart(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CasePartContext casePart() throws RecognitionException {
        CasePartContext _localctx = new CasePartContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_casePart);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(117);
                ifCondition();
                setState(123);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND || _la == OR) {
                    {
                        {
                            setState(118);
                            join();
                            setState(119);
                            ifCondition();
                        }
                    }
                    setState(125);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(127);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(126);
                        match(COLON);
                    }
                }

                setState(129);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IfExprContext extends ParserRuleContext {
        public IfPartContext ifPart() {
            return getRuleContext(IfPartContext.class, 0);
        }

        public List<ElseIfPartContext> elseIfPart() {
            return getRuleContexts(ElseIfPartContext.class);
        }

        public ElseIfPartContext elseIfPart(int i) {
            return getRuleContext(ElseIfPartContext.class, i);
        }

        public ElsePartContext elsePart() {
            return getRuleContext(ElsePartContext.class, 0);
        }

        public IfExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterIfExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitIfExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitIfExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IfExprContext ifExpr() throws RecognitionException {
        IfExprContext _localctx = new IfExprContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_ifExpr);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(131);
                ifPart();
                setState(135);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(132);
                                elseIfPart();
                            }
                        }
                    }
                    setState(137);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                }
                setState(139);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                    case 1: {
                        setState(138);
                        elsePart();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IfPartContext extends ParserRuleContext {
        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public List<IfConditionContext> ifCondition() {
            return getRuleContexts(IfConditionContext.class);
        }

        public IfConditionContext ifCondition(int i) {
            return getRuleContext(IfConditionContext.class, i);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        public IfPartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifPart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterIfPart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitIfPart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitIfPart(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IfPartContext ifPart() throws RecognitionException {
        IfPartContext _localctx = new IfPartContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_ifPart);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(141);
                match(T__4);
                setState(142);
                match(LeftParen);
                setState(143);
                ifCondition();
                setState(149);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND || _la == OR) {
                    {
                        {
                            setState(144);
                            join();
                            setState(145);
                            ifCondition();
                        }
                    }
                    setState(151);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(152);
                match(RightParen);
                setState(153);
                match(T__2);
                setState(154);
                block();
                setState(155);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ElseIfPartContext extends ParserRuleContext {
        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public List<IfConditionContext> ifCondition() {
            return getRuleContexts(IfConditionContext.class);
        }

        public IfConditionContext ifCondition(int i) {
            return getRuleContext(IfConditionContext.class, i);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        public ElseIfPartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elseIfPart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterElseIfPart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitElseIfPart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitElseIfPart(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ElseIfPartContext elseIfPart() throws RecognitionException {
        ElseIfPartContext _localctx = new ElseIfPartContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_elseIfPart);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(157);
                match(T__5);
                setState(158);
                match(T__4);
                setState(159);
                match(LeftParen);
                setState(160);
                ifCondition();
                setState(166);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND || _la == OR) {
                    {
                        {
                            setState(161);
                            join();
                            setState(162);
                            ifCondition();
                        }
                    }
                    setState(168);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(169);
                match(RightParen);
                setState(170);
                match(T__2);
                setState(171);
                block();
                setState(172);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ElsePartContext extends ParserRuleContext {
        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public ElsePartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elsePart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterElsePart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitElsePart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitElsePart(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ElsePartContext elsePart() throws RecognitionException {
        ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_elsePart);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(174);
                match(T__5);
                setState(175);
                match(T__2);
                setState(176);
                block();
                setState(177);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BlockContext extends ParserRuleContext {
        public List<ExprBlockContext> exprBlock() {
            return getRuleContexts(ExprBlockContext.class);
        }

        public ExprBlockContext exprBlock(int i) {
            return getRuleContext(ExprBlockContext.class, i);
        }

        public ReturnExprContext returnExpr() {
            return getRuleContext(ReturnExprContext.class, 0);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_block);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(182);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(179);
                                exprBlock();
                            }
                        }
                    }
                    setState(184);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                }
                setState(186);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                    case 1: {
                        setState(185);
                        returnExpr();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprBlockContext extends ParserRuleContext {
        public VariableAssignContext variableAssign() {
            return getRuleContext(VariableAssignContext.class, 0);
        }

        public IfExprContext ifExpr() {
            return getRuleContext(IfExprContext.class, 0);
        }

        public CaseExprContext caseExpr() {
            return getRuleContext(CaseExprContext.class, 0);
        }

        public ExprBlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprBlock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterExprBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitExprBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitExprBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprBlockContext exprBlock() throws RecognitionException {
        ExprBlockContext _localctx = new ExprBlockContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_exprBlock);
        try {
            setState(191);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__8:
                case Identifier:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(188);
                    variableAssign();
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(189);
                    ifExpr();
                }
                break;
                case T__1:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(190);
                    caseExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReturnExprContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ReturnExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterReturnExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitReturnExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitReturnExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ReturnExprContext returnExpr() throws RecognitionException {
        ReturnExprContext _localctx = new ReturnExprContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_returnExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__6) {
                    {
                        setState(193);
                        match(T__6);
                    }
                }

                setState(196);
                expr();
                setState(198);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                    case 1: {
                        setState(197);
                        match(T__7);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public List<ItemContext> item() {
            return getRuleContexts(ItemContext.class);
        }

        public ItemContext item(int i) {
            return getRuleContext(ItemContext.class, i);
        }

        public List<TerminalNode> ArithmeticOperator() {
            return getTokens(ConfigSqlParserParser.ArithmeticOperator);
        }

        public TerminalNode ArithmeticOperator(int i) {
            return getToken(ConfigSqlParserParser.ArithmeticOperator, i);
        }

        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        ExprContext _localctx = new ExprContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_expr);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(200);
                item();
                setState(205);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(201);
                                match(ArithmeticOperator);
                                setState(202);
                                item();
                            }
                        }
                    }
                    setState(207);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IfConditionContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LogicalOperator() {
            return getToken(ConfigSqlParserParser.LogicalOperator, 0);
        }

        public IfConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterIfCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitIfCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitIfCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IfConditionContext ifCondition() throws RecognitionException {
        IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_ifCondition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                expr();
                setState(209);
                match(LogicalOperator);
                setState(210);
                expr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableAssignContext extends ParserRuleContext {
        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public ItemContext item() {
            return getRuleContext(ItemContext.class, 0);
        }

        public VariableAssignContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableAssign;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterVariableAssign(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitVariableAssign(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitVariableAssign(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VariableAssignContext variableAssign() throws RecognitionException {
        VariableAssignContext _localctx = new VariableAssignContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_variableAssign);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(213);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__8) {
                    {
                        setState(212);
                        match(T__8);
                    }
                }

                setState(215);
                variable();
                setState(216);
                match(T__9);
                setState(217);
                item();
                setState(219);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                    case 1: {
                        setState(218);
                        match(T__7);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ItemContext extends ParserRuleContext {
        public ItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_item;
        }

        public ItemContext() {
        }

        public void copyFrom(ItemContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SingleParenJoinContext extends ItemContext {
        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public ItemContext item() {
            return getRuleContext(ItemContext.class, 0);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public SingleParenJoinContext(ItemContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterSingleParenJoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitSingleParenJoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitSingleParenJoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParenJoinContext extends ItemContext {
        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public List<ItemContext> item() {
            return getRuleContexts(ItemContext.class);
        }

        public ItemContext item(int i) {
            return getRuleContext(ItemContext.class, i);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public List<TerminalNode> ArithmeticOperator() {
            return getTokens(ConfigSqlParserParser.ArithmeticOperator);
        }

        public TerminalNode ArithmeticOperator(int i) {
            return getToken(ConfigSqlParserParser.ArithmeticOperator, i);
        }

        public ParenJoinContext(ItemContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterParenJoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitParenJoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitParenJoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SimpleJoinContext extends ItemContext {
        public List<UnitContext> unit() {
            return getRuleContexts(UnitContext.class);
        }

        public UnitContext unit(int i) {
            return getRuleContext(UnitContext.class, i);
        }

        public List<TerminalNode> ArithmeticOperator() {
            return getTokens(ConfigSqlParserParser.ArithmeticOperator);
        }

        public TerminalNode ArithmeticOperator(int i) {
            return getToken(ConfigSqlParserParser.ArithmeticOperator, i);
        }

        public SimpleJoinContext(ItemContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterSimpleJoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitSimpleJoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitSimpleJoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ItemContext item() throws RecognitionException {
        ItemContext _localctx = new ItemContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_item);
        int _la;
        try {
            int _alt;
            setState(243);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                case 1:
                    _localctx = new SimpleJoinContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(221);
                    unit();
                    setState(226);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(222);
                                    match(ArithmeticOperator);
                                    setState(223);
                                    unit();
                                }
                            }
                        }
                        setState(228);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
                    }
                }
                break;
                case 2:
                    _localctx = new SingleParenJoinContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(229);
                    match(LeftParen);
                    setState(230);
                    item();
                    setState(231);
                    match(RightParen);
                }
                break;
                case 3:
                    _localctx = new ParenJoinContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(233);
                    match(LeftParen);
                    setState(234);
                    item();
                    setState(237);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(235);
                                match(ArithmeticOperator);
                                setState(236);
                                item();
                            }
                        }
                        setState(239);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while (_la == ArithmeticOperator);
                    setState(241);
                    match(RightParen);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UnitContext extends ParserRuleContext {
        public DatasetContext dataset() {
            return getRuleContext(DatasetContext.class, 0);
        }

        public FunctionContext function() {
            return getRuleContext(FunctionContext.class, 0);
        }

        public SetContext set() {
            return getRuleContext(SetContext.class, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(ConfigSqlParserParser.INTEGER, 0);
        }

        public TerminalNode BOOLEAN() {
            return getToken(ConfigSqlParserParser.BOOLEAN, 0);
        }

        public TerminalNode STRING() {
            return getToken(ConfigSqlParserParser.STRING, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(ConfigSqlParserParser.NUMBER, 0);
        }

        public TerminalNode NULL() {
            return getToken(ConfigSqlParserParser.NULL, 0);
        }

        public UnitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterUnit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitUnit(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitUnit(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UnitContext unit() throws RecognitionException {
        UnitContext _localctx = new UnitContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_unit);
        try {
            setState(254);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(245);
                    dataset();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(246);
                    function();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(247);
                    set(0);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(248);
                    variable();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(249);
                    match(INTEGER);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(250);
                    match(BOOLEAN);
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(251);
                    match(STRING);
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(252);
                    match(NUMBER);
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(253);
                    match(NULL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(ConfigSqlParserParser.Identifier, 0);
        }

        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitVariable(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitVariable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_variable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(256);
                match(Identifier);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DatasetContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(ConfigSqlParserParser.Identifier, 0);
        }

        public AggregateContext aggregate() {
            return getRuleContext(AggregateContext.class, 0);
        }

        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public PropertyContext property() {
            return getRuleContext(PropertyContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ConfigSqlParserParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ConfigSqlParserParser.COMMA, i);
        }

        public ConditionsContext conditions() {
            return getRuleContext(ConditionsContext.class, 0);
        }

        public TerminalNode ORDER() {
            return getToken(ConfigSqlParserParser.ORDER, 0);
        }

        public DatasetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dataset;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterDataset(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitDataset(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitDataset(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DatasetContext dataset() throws RecognitionException {
        DatasetContext _localctx = new DatasetContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_dataset);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(258);
                match(Identifier);
                setState(259);
                match(T__10);
                setState(260);
                aggregate();
                setState(261);
                match(LeftParen);
                setState(263);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Identifier) {
                    {
                        setState(262);
                        property(0);
                    }
                }

                setState(267);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
                    case 1: {
                        setState(265);
                        match(COMMA);
                        setState(266);
                        conditions();
                    }
                    break;
                }
                setState(271);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(269);
                        match(COMMA);
                        setState(270);
                        match(ORDER);
                    }
                }

                setState(273);
                match(RightParen);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FunctionContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(ConfigSqlParserParser.Identifier, 0);
        }

        public TerminalNode LeftParen() {
            return getToken(ConfigSqlParserParser.LeftParen, 0);
        }

        public TerminalNode RightParen() {
            return getToken(ConfigSqlParserParser.RightParen, 0);
        }

        public FunctionParameterContext functionParameter() {
            return getRuleContext(FunctionParameterContext.class, 0);
        }

        public FunctionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitFunction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FunctionContext function() throws RecognitionException {
        FunctionContext _localctx = new FunctionContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_function);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(275);
                match(Identifier);
                setState(276);
                match(LeftParen);
                setState(278);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << NULL) | (1L << LeftParen) | (1L << STRING) | (1L << INTEGER) | (1L << NUMBER) | (1L << Identifier))) != 0)) {
                    {
                        setState(277);
                        functionParameter();
                    }
                }

                setState(280);
                match(RightParen);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FunctionParameterContext extends ParserRuleContext {
        public List<ItemContext> item() {
            return getRuleContexts(ItemContext.class);
        }

        public ItemContext item(int i) {
            return getRuleContext(ItemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ConfigSqlParserParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ConfigSqlParserParser.COMMA, i);
        }

        public FunctionParameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionParameter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterFunctionParameter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitFunctionParameter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitFunctionParameter(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FunctionParameterContext functionParameter() throws RecognitionException {
        FunctionParameterContext _localctx = new FunctionParameterContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_functionParameter);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(282);
                item();
                setState(289);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << COMMA) | (1L << NULL) | (1L << LeftParen) | (1L << STRING) | (1L << INTEGER) | (1L << NUMBER) | (1L << Identifier))) != 0)) {
                    {
                        {
                            setState(284);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(283);
                                    match(COMMA);
                                }
                            }

                            setState(286);
                            item();
                        }
                    }
                    setState(291);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SetContext extends ParserRuleContext {
        public SetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_set;
        }

        public SetContext() {
        }

        public void copyFrom(SetContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SimpleDataContext extends SetContext {
        public SimpleValueContext simpleValue() {
            return getRuleContext(SimpleValueContext.class, 0);
        }

        public SimpleDataContext(SetContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterSimpleData(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitSimpleData(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitSimpleData(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class RangeContext extends SetContext {
        public List<SetContext> set() {
            return getRuleContexts(SetContext.class);
        }

        public SetContext set(int i) {
            return getRuleContext(SetContext.class, i);
        }

        public RangeContext(SetContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterRange(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitRange(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitRange(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SetContext set() throws RecognitionException {
        return set(0);
    }

    private SetContext set(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        SetContext _localctx = new SetContext(_ctx, _parentState);
        SetContext _prevctx = _localctx;
        int _startState = 44;
        enterRecursionRule(_localctx, 44, RULE_set, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    _localctx = new SimpleDataContext(_localctx);
                    _ctx = _localctx;
                    _prevctx = _localctx;

                    setState(293);
                    simpleValue();
                }
                _ctx.stop = _input.LT(-1);
                setState(300);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 30, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new RangeContext(new SetContext(_parentctx, _parentState));
                                pushNewRecursionContext(_localctx, _startState, RULE_set);
                                setState(295);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(296);
                                match(T__11);
                                setState(297);
                                set(2);
                            }
                        }
                    }
                    setState(302);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 30, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class ConditionsContext extends ParserRuleContext {
        public List<ConditionContext> condition() {
            return getRuleContexts(ConditionContext.class);
        }

        public ConditionContext condition(int i) {
            return getRuleContext(ConditionContext.class, i);
        }

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        public ConditionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditions;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterConditions(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitConditions(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitConditions(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionsContext conditions() throws RecognitionException {
        ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_conditions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(303);
                condition();
                setState(309);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND || _la == OR) {
                    {
                        {
                            setState(304);
                            join();
                            setState(305);
                            condition();
                        }
                    }
                    setState(311);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConditionContext extends ParserRuleContext {
        public ConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_condition;
        }

        public ConditionContext() {
        }

        public void copyFrom(ConditionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ExprConditionContext extends ConditionContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LogicalOperator() {
            return getToken(ConfigSqlParserParser.LogicalOperator, 0);
        }

        public ExprConditionContext(ConditionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterExprCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitExprCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitExprCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CurrentValueConditionContext extends ConditionContext {
        public CurrentValueContext currentValue() {
            return getRuleContext(CurrentValueContext.class, 0);
        }

        public TerminalNode LogicalOperator() {
            return getToken(ConfigSqlParserParser.LogicalOperator, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public CurrentValueConditionContext(ConditionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterCurrentValueCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitCurrentValueCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitCurrentValueCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PropertyConditionContext extends ConditionContext {
        public PropertyContext property() {
            return getRuleContext(PropertyContext.class, 0);
        }

        public TerminalNode LogicalOperator() {
            return getToken(ConfigSqlParserParser.LogicalOperator, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public PropertyConditionContext(ConditionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterPropertyCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitPropertyCondition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitPropertyCondition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConditionContext condition() throws RecognitionException {
        ConditionContext _localctx = new ConditionContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_condition);
        try {
            setState(324);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 32, _ctx)) {
                case 1:
                    _localctx = new PropertyConditionContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(312);
                    property(0);
                    setState(313);
                    match(LogicalOperator);
                    setState(314);
                    expr();
                }
                break;
                case 2:
                    _localctx = new CurrentValueConditionContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(316);
                    currentValue();
                    setState(317);
                    match(LogicalOperator);
                    setState(318);
                    expr();
                }
                break;
                case 3:
                    _localctx = new ExprConditionContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(320);
                    expr();
                    setState(321);
                    match(LogicalOperator);
                    setState(322);
                    expr();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PropertyContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(ConfigSqlParserParser.Identifier, 0);
        }

        public List<PropertyContext> property() {
            return getRuleContexts(PropertyContext.class);
        }

        public PropertyContext property(int i) {
            return getRuleContext(PropertyContext.class, i);
        }

        public PropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_property;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterProperty(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitProperty(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitProperty(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PropertyContext property() throws RecognitionException {
        return property(0);
    }

    private PropertyContext property(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        PropertyContext _localctx = new PropertyContext(_ctx, _parentState);
        PropertyContext _prevctx = _localctx;
        int _startState = 50;
        enterRecursionRule(_localctx, 50, RULE_property, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(327);
                    match(Identifier);
                }
                _ctx.stop = _input.LT(-1);
                setState(334);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 33, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new PropertyContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_property);
                                setState(329);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(330);
                                match(T__10);
                                setState(331);
                                property(2);
                            }
                        }
                    }
                    setState(336);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 33, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class CurrentValueContext extends ParserRuleContext {
        public CurrentValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_currentValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterCurrentValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).exitCurrentValue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitCurrentValue(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CurrentValueContext currentValue() throws RecognitionException {
        CurrentValueContext _localctx = new CurrentValueContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_currentValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(337);
                match(T__12);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SimpleValueContext extends ParserRuleContext {
        public TerminalNode INTEGER() {
            return getToken(ConfigSqlParserParser.INTEGER, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(ConfigSqlParserParser.NUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(ConfigSqlParserParser.STRING, 0);
        }

        public TerminalNode BOOLEAN() {
            return getToken(ConfigSqlParserParser.BOOLEAN, 0);
        }

        public TerminalNode NULL() {
            return getToken(ConfigSqlParserParser.NULL, 0);
        }

        public SimpleValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener)
                ((ConfigSqlParserListener) listener).enterSimpleValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitSimpleValue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitSimpleValue(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SimpleValueContext simpleValue() throws RecognitionException {
        SimpleValueContext _localctx = new SimpleValueContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_simpleValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(339);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << NULL) | (1L << STRING) | (1L << INTEGER) | (1L << NUMBER))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class JoinContext extends ParserRuleContext {
        public TerminalNode AND() {
            return getToken(ConfigSqlParserParser.AND, 0);
        }

        public TerminalNode OR() {
            return getToken(ConfigSqlParserParser.OR, 0);
        }

        public JoinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_join;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterJoin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitJoin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitJoin(this);
            else return visitor.visitChildren(this);
        }
    }

    public final JoinContext join() throws RecognitionException {
        JoinContext _localctx = new JoinContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_join);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(341);
                _la = _input.LA(1);
                if (!(_la == AND || _la == OR)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AggregateContext extends ParserRuleContext {
        public TerminalNode Identifier() {
            return getToken(ConfigSqlParserParser.Identifier, 0);
        }

        public AggregateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aggregate;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).enterAggregate(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ConfigSqlParserListener) ((ConfigSqlParserListener) listener).exitAggregate(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ConfigSqlParserVisitor)
                return ((ConfigSqlParserVisitor<? extends T>) visitor).visitAggregate(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AggregateContext aggregate() throws RecognitionException {
        AggregateContext _localctx = new AggregateContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_aggregate);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(343);
                match(Identifier);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 2:
                return exprComposite_sempred((ExprCompositeContext) _localctx, predIndex);
            case 22:
                return set_sempred((SetContext) _localctx, predIndex);
            case 25:
                return property_sempred((PropertyContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean exprComposite_sempred(ExprCompositeContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean set_sempred(SetContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean property_sempred(PropertyContext _localctx, int predIndex) {
        switch (predIndex) {
            case 2:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static final String _serializedATN =
            "\u0004\u0001%\u015a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
                    "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
                    "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015" +
                    "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018" +
                    "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b" +
                    "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0004\u0000" +
                    ">\b\u0000\u000b\u0000\f\u0000?\u0001\u0000\u0001\u0000\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001I\b\u0001\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0003\u0002R\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005" +
                    "\u0002W\b\u0002\n\u0002\f\u0002Z\t\u0002\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0005\u0003`\b\u0003\n\u0003\f\u0003c\t\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001" +
                    "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004o\b\u0004\n\u0004" +
                    "\f\u0004r\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001" +
                    "\u0005\u0001\u0005\u0005\u0005z\b\u0005\n\u0005\f\u0005}\t\u0005\u0001" +
                    "\u0005\u0003\u0005\u0080\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001" +
                    "\u0006\u0005\u0006\u0086\b\u0006\n\u0006\f\u0006\u0089\t\u0006\u0001\u0006" +
                    "\u0003\u0006\u008c\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007\u0097" +
                    "\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a5\b\b\n" +
                    "\b\f\b\u00a8\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\n\u0005\n\u00b5\b\n\n\n\f\n\u00b8\t\n" +
                    "\u0001\n\u0003\n\u00bb\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b" +
                    "\u00c0\b\u000b\u0001\f\u0003\f\u00c3\b\f\u0001\f\u0001\f\u0003\f\u00c7" +
                    "\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00cc\b\r\n\r\f\r\u00cf\t\r\u0001" +
                    "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003\u000f\u00d6" +
                    "\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00dc" +
                    "\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00e1\b\u0010" +
                    "\n\u0010\f\u0010\u00e4\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00ee" +
                    "\b\u0010\u000b\u0010\f\u0010\u00ef\u0001\u0010\u0001\u0010\u0003\u0010" +
                    "\u00f4\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ff\b\u0011" +
                    "\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0003\u0013\u0108\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013" +
                    "\u010c\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0110\b\u0013\u0001" +
                    "\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0117" +
                    "\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u011d" +
                    "\b\u0015\u0001\u0015\u0005\u0015\u0120\b\u0015\n\u0015\f\u0015\u0123\t" +
                    "\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001" +
                    "\u0016\u0005\u0016\u012b\b\u0016\n\u0016\f\u0016\u012e\t\u0016\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0134\b\u0017\n\u0017" +
                    "\f\u0017\u0137\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0003\u0018\u0145\b\u0018\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u014d\b\u0019" +
                    "\n\u0019\f\u0019\u0150\t\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001" +
                    "\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0000" +
                    "\u0003\u0004,2\u001e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014" +
                    "\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:\u0000\u0002\u0004\u0000" +
                    "\u0012\u0012\u0015\u0015\u0018\u0018\u001b\u001c\u0001\u0000\u0019\u001a" +
                    "\u016b\u0000=\u0001\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004" +
                    "Q\u0001\u0000\u0000\u0000\u0006[\u0001\u0000\u0000\u0000\bi\u0001\u0000" +
                    "\u0000\u0000\nu\u0001\u0000\u0000\u0000\f\u0083\u0001\u0000\u0000\u0000" +
                    "\u000e\u008d\u0001\u0000\u0000\u0000\u0010\u009d\u0001\u0000\u0000\u0000" +
                    "\u0012\u00ae\u0001\u0000\u0000\u0000\u0014\u00b6\u0001\u0000\u0000\u0000" +
                    "\u0016\u00bf\u0001\u0000\u0000\u0000\u0018\u00c2\u0001\u0000\u0000\u0000" +
                    "\u001a\u00c8\u0001\u0000\u0000\u0000\u001c\u00d0\u0001\u0000\u0000\u0000" +
                    "\u001e\u00d5\u0001\u0000\u0000\u0000 \u00f3\u0001\u0000\u0000\u0000\"" +
                    "\u00fe\u0001\u0000\u0000\u0000$\u0100\u0001\u0000\u0000\u0000&\u0102\u0001" +
                    "\u0000\u0000\u0000(\u0113\u0001\u0000\u0000\u0000*\u011a\u0001\u0000\u0000" +
                    "\u0000,\u0124\u0001\u0000\u0000\u0000.\u012f\u0001\u0000\u0000\u00000" +
                    "\u0144\u0001\u0000\u0000\u00002\u0146\u0001\u0000\u0000\u00004\u0151\u0001" +
                    "\u0000\u0000\u00006\u0153\u0001\u0000\u0000\u00008\u0155\u0001\u0000\u0000" +
                    "\u0000:\u0157\u0001\u0000\u0000\u0000<>\u0003\u0002\u0001\u0000=<\u0001" +
                    "\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000" +
                    "?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0000\u0000" +
                    "\u0001B\u0001\u0001\u0000\u0000\u0000CI\u0003\u0004\u0002\u0000DI\u0003" +
                    "\f\u0006\u0000EI\u0003\b\u0004\u0000FI\u0003\u0018\f\u0000GI\u0003\u001e" +
                    "\u000f\u0000HC\u0001\u0000\u0000\u0000HD\u0001\u0000\u0000\u0000HE\u0001" +
                    "\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000" +
                    "I\u0003\u0001\u0000\u0000\u0000JK\u0006\u0002\uffff\uffff\u0000KR\u0003" +
                    "\u001a\r\u0000LR\u0003\u0006\u0003\u0000MN\u0005\u0016\u0000\u0000NO\u0003" +
                    "\u0004\u0002\u0000OP\u0005\u0017\u0000\u0000PR\u0001\u0000\u0000\u0000" +
                    "QJ\u0001\u0000\u0000\u0000QL\u0001\u0000\u0000\u0000QM\u0001\u0000\u0000" +
                    "\u0000RX\u0001\u0000\u0000\u0000ST\n\u0001\u0000\u0000TU\u0005%\u0000" +
                    "\u0000UW\u0003\u0004\u0002\u0002VS\u0001\u0000\u0000\u0000WZ\u0001\u0000" +
                    "\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u0005" +
                    "\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[a\u0003\u001c\u000e" +
                    "\u0000\\]\u00038\u001c\u0000]^\u0003\u001c\u000e\u0000^`\u0001\u0000\u0000" +
                    "\u0000_\\\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000" +
                    "\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001" +
                    "\u0000\u0000\u0000de\u0005\u0001\u0000\u0000ef\u0003\u0014\n\u0000fg\u0005" +
                    "\u0013\u0000\u0000gh\u0003\u0014\n\u0000h\u0007\u0001\u0000\u0000\u0000" +
                    "ij\u0005\u0002\u0000\u0000jk\u0005\u0003\u0000\u0000kp\u0003\n\u0005\u0000" +
                    "lm\u0005\u0014\u0000\u0000mo\u0003\n\u0005\u0000nl\u0001\u0000\u0000\u0000" +
                    "or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000" +
                    "\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0005\u0004" +
                    "\u0000\u0000t\t\u0001\u0000\u0000\u0000u{\u0003\u001c\u000e\u0000vw\u0003" +
                    "8\u001c\u0000wx\u0003\u001c\u000e\u0000xz\u0001\u0000\u0000\u0000yv\u0001" +
                    "\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000" +
                    "{|\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000" +
                    "\u0000\u0000~\u0080\u0005\u0013\u0000\u0000\u007f~\u0001\u0000\u0000\u0000" +
                    "\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000" +
                    "\u0081\u0082\u0003\u0014\n\u0000\u0082\u000b\u0001\u0000\u0000\u0000\u0083" +
                    "\u0087\u0003\u000e\u0007\u0000\u0084\u0086\u0003\u0010\b\u0000\u0085\u0084" +
                    "\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085" +
                    "\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008b" +
                    "\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008c" +
                    "\u0003\u0012\t\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001" +
                    "\u0000\u0000\u0000\u008c\r\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0005" +
                    "\u0000\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f\u0095\u0003\u001c" +
                    "\u000e\u0000\u0090\u0091\u00038\u001c\u0000\u0091\u0092\u0003\u001c\u000e" +
                    "\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0090\u0001\u0000\u0000" +
                    "\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000" +
                    "\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000" +
                    "\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0017\u0000" +
                    "\u0000\u0099\u009a\u0005\u0003\u0000\u0000\u009a\u009b\u0003\u0014\n\u0000" +
                    "\u009b\u009c\u0005\u0004\u0000\u0000\u009c\u000f\u0001\u0000\u0000\u0000" +
                    "\u009d\u009e\u0005\u0006\u0000\u0000\u009e\u009f\u0005\u0005\u0000\u0000" +
                    "\u009f\u00a0\u0005\u0016\u0000\u0000\u00a0\u00a6\u0003\u001c\u000e\u0000" +
                    "\u00a1\u00a2\u00038\u001c\u0000\u00a2\u00a3\u0003\u001c\u000e\u0000\u00a3" +
                    "\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a5" +
                    "\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6" +
                    "\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8" +
                    "\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0017\u0000\u0000\u00aa" +
                    "\u00ab\u0005\u0003\u0000\u0000\u00ab\u00ac\u0003\u0014\n\u0000\u00ac\u00ad" +
                    "\u0005\u0004\u0000\u0000\u00ad\u0011\u0001\u0000\u0000\u0000\u00ae\u00af" +
                    "\u0005\u0006\u0000\u0000\u00af\u00b0\u0005\u0003\u0000\u0000\u00b0\u00b1" +
                    "\u0003\u0014\n\u0000\u00b1\u00b2\u0005\u0004\u0000\u0000\u00b2\u0013\u0001" +
                    "\u0000\u0000\u0000\u00b3\u00b5\u0003\u0016\u000b\u0000\u00b4\u00b3\u0001" +
                    "\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001" +
                    "\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001" +
                    "\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003" +
                    "\u0018\f\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000" +
                    "\u0000\u0000\u00bb\u0015\u0001\u0000\u0000\u0000\u00bc\u00c0\u0003\u001e" +
                    "\u000f\u0000\u00bd\u00c0\u0003\f\u0006\u0000\u00be\u00c0\u0003\b\u0004" +
                    "\u0000\u00bf\u00bc\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000" +
                    "\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u0017\u0001\u0000\u0000" +
                    "\u0000\u00c1\u00c3\u0005\u0007\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000" +
                    "\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000" +
                    "\u0000\u00c4\u00c6\u0003\u001a\r\u0000\u00c5\u00c7\u0005\b\u0000\u0000" +
                    "\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000" +
                    "\u00c7\u0019\u0001\u0000\u0000\u0000\u00c8\u00cd\u0003 \u0010\u0000\u00c9" +
                    "\u00ca\u0005\u000f\u0000\u0000\u00ca\u00cc\u0003 \u0010\u0000\u00cb\u00c9" +
                    "\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb" +
                    "\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u001b" +
                    "\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1" +
                    "\u0003\u001a\r\u0000\u00d1\u00d2\u0005\u0010\u0000\u0000\u00d2\u00d3\u0003" +
                    "\u001a\r\u0000\u00d3\u001d\u0001\u0000\u0000\u0000\u00d4\u00d6\u0005\t" +
                    "\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000" +
                    "\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0003$\u0012" +
                    "\u0000\u00d8\u00d9\u0005\n\u0000\u0000\u00d9\u00db\u0003 \u0010\u0000" +
                    "\u00da\u00dc\u0005\b\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db" +
                    "\u00dc\u0001\u0000\u0000\u0000\u00dc\u001f\u0001\u0000\u0000\u0000\u00dd" +
                    "\u00e2\u0003\"\u0011\u0000\u00de\u00df\u0005\u000f\u0000\u0000\u00df\u00e1" +
                    "\u0003\"\u0011\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001" +
                    "\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001" +
                    "\u0000\u0000\u0000\u00e3\u00f4\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001" +
                    "\u0000\u0000\u0000\u00e5\u00e6\u0005\u0016\u0000\u0000\u00e6\u00e7\u0003" +
                    " \u0010\u0000\u00e7\u00e8\u0005\u0017\u0000\u0000\u00e8\u00f4\u0001\u0000" +
                    "\u0000\u0000\u00e9\u00ea\u0005\u0016\u0000\u0000\u00ea\u00ed\u0003 \u0010" +
                    "\u0000\u00eb\u00ec\u0005\u000f\u0000\u0000\u00ec\u00ee\u0003 \u0010\u0000" +
                    "\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000" +
                    "\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000" +
                    "\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0017\u0000\u0000" +
                    "\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3\u00dd\u0001\u0000\u0000\u0000" +
                    "\u00f3\u00e5\u0001\u0000\u0000\u0000\u00f3\u00e9\u0001\u0000\u0000\u0000" +
                    "\u00f4!\u0001\u0000\u0000\u0000\u00f5\u00ff\u0003&\u0013\u0000\u00f6\u00ff" +
                    "\u0003(\u0014\u0000\u00f7\u00ff\u0003,\u0016\u0000\u00f8\u00ff\u0003$" +
                    "\u0012\u0000\u00f9\u00ff\u0005\u001b\u0000\u0000\u00fa\u00ff\u0005\u0012" +
                    "\u0000\u0000\u00fb\u00ff\u0005\u0018\u0000\u0000\u00fc\u00ff\u0005\u001c" +
                    "\u0000\u0000\u00fd\u00ff\u0005\u0015\u0000\u0000\u00fe\u00f5\u0001\u0000" +
                    "\u0000\u0000\u00fe\u00f6\u0001\u0000\u0000\u0000\u00fe\u00f7\u0001\u0000" +
                    "\u0000\u0000\u00fe\u00f8\u0001\u0000\u0000\u0000\u00fe\u00f9\u0001\u0000" +
                    "\u0000\u0000\u00fe\u00fa\u0001\u0000\u0000\u0000\u00fe\u00fb\u0001\u0000" +
                    "\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00fd\u0001\u0000" +
                    "\u0000\u0000\u00ff#\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u001f\u0000" +
                    "\u0000\u0101%\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u001f\u0000\u0000" +
                    "\u0103\u0104\u0005\u000b\u0000\u0000\u0104\u0105\u0003:\u001d\u0000\u0105" +
                    "\u0107\u0005\u0016\u0000\u0000\u0106\u0108\u00032\u0019\u0000\u0107\u0106" +
                    "\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u010b" +
                    "\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u0014\u0000\u0000\u010a\u010c" +
                    "\u0003.\u0017\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001" +
                    "\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010e\u0005" +
                    "\u0014\u0000\u0000\u010e\u0110\u0005\u0011\u0000\u0000\u010f\u010d\u0001" +
                    "\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0001" +
                    "\u0000\u0000\u0000\u0111\u0112\u0005\u0017\u0000\u0000\u0112\'\u0001\u0000" +
                    "\u0000\u0000\u0113\u0114\u0005\u001f\u0000\u0000\u0114\u0116\u0005\u0016" +
                    "\u0000\u0000\u0115\u0117\u0003*\u0015\u0000\u0116\u0115\u0001\u0000\u0000" +
                    "\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000" +
                    "\u0000\u0118\u0119\u0005\u0017\u0000\u0000\u0119)\u0001\u0000\u0000\u0000" +
                    "\u011a\u0121\u0003 \u0010\u0000\u011b\u011d\u0005\u0014\u0000\u0000\u011c" +
                    "\u011b\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d" +
                    "\u011e\u0001\u0000\u0000\u0000\u011e\u0120\u0003 \u0010\u0000\u011f\u011c" +
                    "\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f" +
                    "\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122+\u0001" +
                    "\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0125\u0006" +
                    "\u0016\uffff\uffff\u0000\u0125\u0126\u00036\u001b\u0000\u0126\u012c\u0001" +
                    "\u0000\u0000\u0000\u0127\u0128\n\u0001\u0000\u0000\u0128\u0129\u0005\f" +
                    "\u0000\u0000\u0129\u012b\u0003,\u0016\u0002\u012a\u0127\u0001\u0000\u0000" +
                    "\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000" +
                    "\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d-\u0001\u0000\u0000\u0000" +
                    "\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0135\u00030\u0018\u0000\u0130" +
                    "\u0131\u00038\u001c\u0000\u0131\u0132\u00030\u0018\u0000\u0132\u0134\u0001" +
                    "\u0000\u0000\u0000\u0133\u0130\u0001\u0000\u0000\u0000\u0134\u0137\u0001" +
                    "\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001" +
                    "\u0000\u0000\u0000\u0136/\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000" +
                    "\u0000\u0000\u0138\u0139\u00032\u0019\u0000\u0139\u013a\u0005\u0010\u0000" +
                    "\u0000\u013a\u013b\u0003\u001a\r\u0000\u013b\u0145\u0001\u0000\u0000\u0000" +
                    "\u013c\u013d\u00034\u001a\u0000\u013d\u013e\u0005\u0010\u0000\u0000\u013e" +
                    "\u013f\u0003\u001a\r\u0000\u013f\u0145\u0001\u0000\u0000\u0000\u0140\u0141" +
                    "\u0003\u001a\r\u0000\u0141\u0142\u0005\u0010\u0000\u0000\u0142\u0143\u0003" +
                    "\u001a\r\u0000\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0138\u0001\u0000" +
                    "\u0000\u0000\u0144\u013c\u0001\u0000\u0000\u0000\u0144\u0140\u0001\u0000" +
                    "\u0000\u0000\u01451\u0001\u0000\u0000\u0000\u0146\u0147\u0006\u0019\uffff" +
                    "\uffff\u0000\u0147\u0148\u0005\u001f\u0000\u0000\u0148\u014e\u0001\u0000" +
                    "\u0000\u0000\u0149\u014a\n\u0001\u0000\u0000\u014a\u014b\u0005\u000b\u0000" +
                    "\u0000\u014b\u014d\u00032\u0019\u0002\u014c\u0149\u0001\u0000\u0000\u0000" +
                    "\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000" +
                    "\u014e\u014f\u0001\u0000\u0000\u0000\u014f3\u0001\u0000\u0000\u0000\u0150" +
                    "\u014e\u0001\u0000\u0000\u0000\u0151\u0152\u0005\r\u0000\u0000\u01525" +
                    "\u0001\u0000\u0000\u0000\u0153\u0154\u0007\u0000\u0000\u0000\u01547\u0001" +
                    "\u0000\u0000\u0000\u0155\u0156\u0007\u0001\u0000\u0000\u01569\u0001\u0000" +
                    "\u0000\u0000\u0157\u0158\u0005\u001f\u0000\u0000\u0158;\u0001\u0000\u0000" +
                    "\u0000\"?HQXap{\u007f\u0087\u008b\u0095\u00a6\u00b6\u00ba\u00bf\u00c2" +
                    "\u00c6\u00cd\u00d5\u00db\u00e2\u00ef\u00f3\u00fe\u0107\u010b\u010f\u0116" +
                    "\u011c\u0121\u012c\u0135\u0144\u014e";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}