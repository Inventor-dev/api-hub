// Generated from ConfigSqlLexer.g4 by ANTLR 4.10.1

package xyz.lemone.apihub.support.sqlparse.expression.dsl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigSqlLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            Cell = 1, ArithmeticOperator = 2, LogicalOperator = 3, ORDER = 4, BOOLEAN = 5, COLON = 6,
            COMMA = 7, NULL = 8, LeftParen = 9, RightParen = 10, STRING = 11, AND = 12, OR = 13,
            INTEGER = 14, NUMBER = 15, EXCLAMATION = 16, EXP = 17, Identifier = 18, LETTER = 19,
            Char = 20, DIGIT = 21, WS = 22, NL = 23;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "Cell", "ArithmeticOperator", "LogicalOperator", "ORDER", "BOOLEAN",
                "COLON", "COMMA", "NULL", "LeftParen", "RightParen", "STRING", "AND",
                "OR", "INTEGER", "NUMBER", "EXCLAMATION", "EXP", "Identifier", "LETTER",
                "Char", "DIGIT", "STRING_CONTENT", "EscapeSequence", "OctalEscape", "UnicodeEscape",
                "HEX", "StartChar", "WS", "NL"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, null, null, "':'", "','", "'null'", "'('", "')'",
                null, null, null, null, null, "'!'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "Cell", "ArithmeticOperator", "LogicalOperator", "ORDER", "BOOLEAN",
                "COLON", "COMMA", "NULL", "LeftParen", "RightParen", "STRING", "AND",
                "OR", "INTEGER", "NUMBER", "EXCLAMATION", "EXP", "Identifier", "LETTER",
                "Char", "DIGIT", "WS", "NL"
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


    public ConfigSqlLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "ConfigSqlLexer.g4";
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\u0004\u0000\u0017\u0117\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
                    "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
                    "\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017" +
                    "\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a" +
                    "\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000" +
                    "\u0004\u0000>\b\u0000\u000b\u0000\f\u0000?\u0001\u0001\u0001\u0001\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002`\b\u0002\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0003\u0003i\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003" +
                    "\u0004t\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b" +
                    "\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001" +
                    "\n\u0001\n\u0003\n\u008b\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0003\u000b\u0092\b\u000b\u0001\f\u0001\f\u0001\f\u0001" +
                    "\f\u0003\f\u0098\b\f\u0001\r\u0003\r\u009b\b\r\u0001\r\u0004\r\u009e\b" +
                    "\r\u000b\r\f\r\u009f\u0001\u000e\u0003\u000e\u00a3\b\u000e\u0001\u000e" +
                    "\u0004\u000e\u00a6\b\u000e\u000b\u000e\f\u000e\u00a7\u0001\u000e\u0001" +
                    "\u000e\u0004\u000e\u00ac\b\u000e\u000b\u000e\f\u000e\u00ad\u0001\u000e" +
                    "\u0003\u000e\u00b1\b\u000e\u0001\u000e\u0003\u000e\u00b4\b\u000e\u0001" +
                    "\u000e\u0004\u000e\u00b7\b\u000e\u000b\u000e\f\u000e\u00b8\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0003\u000e\u00be\b\u000e\u0001\u000e\u0004\u000e" +
                    "\u00c1\b\u000e\u000b\u000e\f\u000e\u00c2\u0003\u000e\u00c5\b\u000e\u0001" +
                    "\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00cb\b\u0010\u0001" +
                    "\u0010\u0004\u0010\u00ce\b\u0010\u000b\u0010\f\u0010\u00cf\u0001\u0011" +
                    "\u0001\u0011\u0005\u0011\u00d4\b\u0011\n\u0011\f\u0011\u00d7\t\u0011\u0001" +
                    "\u0012\u0004\u0012\u00da\b\u0012\u000b\u0012\f\u0012\u00db\u0001\u0013" +
                    "\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00e2\b\u0013\u0001\u0014" +
                    "\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00e8\b\u0015\n\u0015" +
                    "\f\u0015\u00eb\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0003\u0016\u00f1\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017" +
                    "\u00fc\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a" +
                    "\u0108\b\u001a\u0001\u001b\u0004\u001b\u010b\b\u001b\u000b\u001b\f\u001b" +
                    "\u010c\u0001\u001b\u0001\u001b\u0001\u001c\u0003\u001c\u0112\b\u001c\u0001" +
                    "\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001" +
                    "\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f" +
                    "\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f" +
                    "\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0000-\u0000/\u0000" +
                    "1\u00003\u00005\u00007\u00169\u0017\u0001\u0000\r\u0004\u0000%%*+--//" +
                    "\u0002\u0000<<>>\u0002\u0000EEee\u0002\u0000++--\u0001\u0000AZ\u0002\u0000" +
                    "--__\u0003\u0000\u00b7\u00b7\u0300\u036f\u203f\u2040\u0001\u000009\u0002" +
                    "\u0000\"\"\'\'\b\u0000\"\"\'\'\\\\bbffnnrrtt\u0003\u000009AFaf\u0007\u0000" +
                    "AZaz\u2070\u218f\u2c00\u2fef\u3001\u8000\ud7ff\u8000\uf900\u8000\ufdcf" +
                    "\u8000\ufdf0\u8000\ufffd\u0003\u0000\t\n\r\r  \u0139\u0000\u0001\u0001" +
                    "\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001" +
                    "\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000" +
                    "\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000" +
                    "\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000" +
                    "\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000" +
                    "\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000" +
                    "\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000" +
                    "\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000" +
                    "\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'" +
                    "\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u00007\u0001\u0000" +
                    "\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000" +
                    "\u0003A\u0001\u0000\u0000\u0000\u0005_\u0001\u0000\u0000\u0000\u0007h" +
                    "\u0001\u0000\u0000\u0000\ts\u0001\u0000\u0000\u0000\u000bu\u0001\u0000" +
                    "\u0000\u0000\rw\u0001\u0000\u0000\u0000\u000fy\u0001\u0000\u0000\u0000" +
                    "\u0011~\u0001\u0000\u0000\u0000\u0013\u0080\u0001\u0000\u0000\u0000\u0015" +
                    "\u008a\u0001\u0000\u0000\u0000\u0017\u0091\u0001\u0000\u0000\u0000\u0019" +
                    "\u0097\u0001\u0000\u0000\u0000\u001b\u009a\u0001\u0000\u0000\u0000\u001d" +
                    "\u00c4\u0001\u0000\u0000\u0000\u001f\u00c6\u0001\u0000\u0000\u0000!\u00c8" +
                    "\u0001\u0000\u0000\u0000#\u00d1\u0001\u0000\u0000\u0000%\u00d9\u0001\u0000" +
                    "\u0000\u0000\'\u00e1\u0001\u0000\u0000\u0000)\u00e3\u0001\u0000\u0000" +
                    "\u0000+\u00e9\u0001\u0000\u0000\u0000-\u00f0\u0001\u0000\u0000\u0000/" +
                    "\u00fb\u0001\u0000\u0000\u00001\u00fd\u0001\u0000\u0000\u00003\u0104\u0001" +
                    "\u0000\u0000\u00005\u0107\u0001\u0000\u0000\u00007\u010a\u0001\u0000\u0000" +
                    "\u00009\u0111\u0001\u0000\u0000\u0000;=\u0003%\u0012\u0000<>\u0003)\u0014" +
                    "\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000" +
                    "\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0002\u0001\u0000\u0000\u0000" +
                    "AB\u0007\u0000\u0000\u0000B\u0004\u0001\u0000\u0000\u0000C`\u0007\u0001" +
                    "\u0000\u0000DE\u0005=\u0000\u0000E`\u0005=\u0000\u0000FG\u0005!\u0000" +
                    "\u0000G`\u0005=\u0000\u0000HI\u0005>\u0000\u0000I`\u0005=\u0000\u0000" +
                    "JK\u0005<\u0000\u0000K`\u0005=\u0000\u0000LM\u0005i\u0000\u0000M`\u0005" +
                    "n\u0000\u0000NO\u0005n\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005t\u0000" +
                    "\u0000QR\u0005 \u0000\u0000RS\u0005i\u0000\u0000S`\u0005n\u0000\u0000" +
                    "TU\u0005n\u0000\u0000UV\u0005o\u0000\u0000VW\u0005t\u0000\u0000WX\u0005" +
                    " \u0000\u0000XY\u0005 \u0000\u0000YZ\u0005i\u0000\u0000Z`\u0005n\u0000" +
                    "\u0000[\\\u0005l\u0000\u0000\\]\u0005i\u0000\u0000]^\u0005k\u0000\u0000" +
                    "^`\u0005e\u0000\u0000_C\u0001\u0000\u0000\u0000_D\u0001\u0000\u0000\u0000" +
                    "_F\u0001\u0000\u0000\u0000_H\u0001\u0000\u0000\u0000_J\u0001\u0000\u0000" +
                    "\u0000_L\u0001\u0000\u0000\u0000_N\u0001\u0000\u0000\u0000_T\u0001\u0000" +
                    "\u0000\u0000_[\u0001\u0000\u0000\u0000`\u0006\u0001\u0000\u0000\u0000" +
                    "ab\u0005d\u0000\u0000bc\u0005e\u0000\u0000cd\u0005s\u0000\u0000di\u0005" +
                    "c\u0000\u0000ef\u0005a\u0000\u0000fg\u0005s\u0000\u0000gi\u0005c\u0000" +
                    "\u0000ha\u0001\u0000\u0000\u0000he\u0001\u0000\u0000\u0000i\b\u0001\u0000" +
                    "\u0000\u0000jk\u0005t\u0000\u0000kl\u0005r\u0000\u0000lm\u0005u\u0000" +
                    "\u0000mt\u0005e\u0000\u0000no\u0005f\u0000\u0000op\u0005a\u0000\u0000" +
                    "pq\u0005l\u0000\u0000qr\u0005s\u0000\u0000rt\u0005e\u0000\u0000sj\u0001" +
                    "\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000t\n\u0001\u0000\u0000\u0000" +
                    "uv\u0005:\u0000\u0000v\f\u0001\u0000\u0000\u0000wx\u0005,\u0000\u0000" +
                    "x\u000e\u0001\u0000\u0000\u0000yz\u0005n\u0000\u0000z{\u0005u\u0000\u0000" +
                    "{|\u0005l\u0000\u0000|}\u0005l\u0000\u0000}\u0010\u0001\u0000\u0000\u0000" +
                    "~\u007f\u0005(\u0000\u0000\u007f\u0012\u0001\u0000\u0000\u0000\u0080\u0081" +
                    "\u0005)\u0000\u0000\u0081\u0014\u0001\u0000\u0000\u0000\u0082\u0083\u0005" +
                    "\"\u0000\u0000\u0083\u0084\u0003+\u0015\u0000\u0084\u0085\u0005\"\u0000" +
                    "\u0000\u0085\u008b\u0001\u0000\u0000\u0000\u0086\u0087\u0005\'\u0000\u0000" +
                    "\u0087\u0088\u0003+\u0015\u0000\u0088\u0089\u0005\'\u0000\u0000\u0089" +
                    "\u008b\u0001\u0000\u0000\u0000\u008a\u0082\u0001\u0000\u0000\u0000\u008a" +
                    "\u0086\u0001\u0000\u0000\u0000\u008b\u0016\u0001\u0000\u0000\u0000\u008c" +
                    "\u008d\u0005a\u0000\u0000\u008d\u008e\u0005n\u0000\u0000\u008e\u0092\u0005" +
                    "d\u0000\u0000\u008f\u0090\u0005&\u0000\u0000\u0090\u0092\u0005&\u0000" +
                    "\u0000\u0091\u008c\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000" +
                    "\u0000\u0092\u0018\u0001\u0000\u0000\u0000\u0093\u0094\u0005o\u0000\u0000" +
                    "\u0094\u0098\u0005r\u0000\u0000\u0095\u0096\u0005|\u0000\u0000\u0096\u0098" +
                    "\u0005|\u0000\u0000\u0097\u0093\u0001\u0000\u0000\u0000\u0097\u0095\u0001" +
                    "\u0000\u0000\u0000\u0098\u001a\u0001\u0000\u0000\u0000\u0099\u009b\u0005" +
                    "-\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000" +
                    "\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009e\u0003)\u0014" +
                    "\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000" +
                    "\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000" +
                    "\u0000\u00a0\u001c\u0001\u0000\u0000\u0000\u00a1\u00a3\u0005-\u0000\u0000" +
                    "\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000" +
                    "\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a6\u0003)\u0014\u0000\u00a5" +
                    "\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7" +
                    "\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8" +
                    "\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005.\u0000\u0000\u00aa\u00ac" +
                    "\u0003)\u0014\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001" +
                    "\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001" +
                    "\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00b1\u0003" +
                    "!\u0010\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000" +
                    "\u0000\u0000\u00b1\u00c5\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005-\u0000" +
                    "\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000" +
                    "\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003)\u0014\u0000" +
                    "\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000" +
                    "\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000" +
                    "\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0003!\u0010\u0000\u00bb" +
                    "\u00c5\u0001\u0000\u0000\u0000\u00bc\u00be\u0005-\u0000\u0000\u00bd\u00bc" +
                    "\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0" +
                    "\u0001\u0000\u0000\u0000\u00bf\u00c1\u0003)\u0014\u0000\u00c0\u00bf\u0001" +
                    "\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001" +
                    "\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001" +
                    "\u0000\u0000\u0000\u00c4\u00a2\u0001\u0000\u0000\u0000\u00c4\u00b3\u0001" +
                    "\u0000\u0000\u0000\u00c4\u00bd\u0001\u0000\u0000\u0000\u00c5\u001e\u0001" +
                    "\u0000\u0000\u0000\u00c6\u00c7\u0005!\u0000\u0000\u00c7 \u0001\u0000\u0000" +
                    "\u0000\u00c8\u00ca\u0007\u0002\u0000\u0000\u00c9\u00cb\u0007\u0003\u0000" +
                    "\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000" +
                    "\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003)\u0014\u0000" +
                    "\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000" +
                    "\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000" +
                    "\u00d0\"\u0001\u0000\u0000\u0000\u00d1\u00d5\u00035\u001a\u0000\u00d2" +
                    "\u00d4\u0003\'\u0013\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7" +
                    "\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6" +
                    "\u0001\u0000\u0000\u0000\u00d6$\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001" +
                    "\u0000\u0000\u0000\u00d8\u00da\u0007\u0004\u0000\u0000\u00d9\u00d8\u0001" +
                    "\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00d9\u0001" +
                    "\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc&\u0001\u0000" +
                    "\u0000\u0000\u00dd\u00e2\u00035\u001a\u0000\u00de\u00e2\u0007\u0005\u0000" +
                    "\u0000\u00df\u00e2\u0003)\u0014\u0000\u00e0\u00e2\u0007\u0006\u0000\u0000" +
                    "\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00de\u0001\u0000\u0000\u0000" +
                    "\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000" +
                    "\u00e2(\u0001\u0000\u0000\u0000\u00e3\u00e4\u0007\u0007\u0000\u0000\u00e4" +
                    "*\u0001\u0000\u0000\u0000\u00e5\u00e8\u0003-\u0016\u0000\u00e6\u00e8\b" +
                    "\b\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000" +
                    "\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000" +
                    "\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea,\u0001\u0000\u0000" +
                    "\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\\\u0000\u0000" +
                    "\u00ed\u00f1\u0007\t\u0000\u0000\u00ee\u00f1\u00031\u0018\u0000\u00ef" +
                    "\u00f1\u0003/\u0017\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000\u00f0\u00ee" +
                    "\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1.\u0001" +
                    "\u0000\u0000\u0000\u00f2\u00f3\u0005\\\u0000\u0000\u00f3\u00f4\u00020" +
                    "3\u0000\u00f4\u00f5\u000207\u0000\u00f5\u00fc\u000207\u0000\u00f6\u00f7" +
                    "\u0005\\\u0000\u0000\u00f7\u00f8\u000207\u0000\u00f8\u00fc\u000207\u0000" +
                    "\u00f9\u00fa\u0005\\\u0000\u0000\u00fa\u00fc\u000207\u0000\u00fb\u00f2" +
                    "\u0001\u0000\u0000\u0000\u00fb\u00f6\u0001\u0000\u0000\u0000\u00fb\u00f9" +
                    "\u0001\u0000\u0000\u0000\u00fc0\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005" +
                    "\\\u0000\u0000\u00fe\u00ff\u0005u\u0000\u0000\u00ff\u0100\u00033\u0019" +
                    "\u0000\u0100\u0101\u00033\u0019\u0000\u0101\u0102\u00033\u0019\u0000\u0102" +
                    "\u0103\u00033\u0019\u0000\u01032\u0001\u0000\u0000\u0000\u0104\u0105\u0007" +
                    "\n\u0000\u0000\u01054\u0001\u0000\u0000\u0000\u0106\u0108\u0007\u000b" +
                    "\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u01086\u0001\u0000\u0000" +
                    "\u0000\u0109\u010b\u0007\f\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000" +
                    "\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000" +
                    "\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000" +
                    "\u010e\u010f\u0006\u001b\u0000\u0000\u010f8\u0001\u0000\u0000\u0000\u0110" +
                    "\u0112\u0005\r\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112" +
                    "\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114" +
                    "\u0005\n\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0006" +
                    "\u001c\u0000\u0000\u0116:\u0001\u0000\u0000\u0000\u001f\u0000?_hs\u008a" +
                    "\u0091\u0097\u009a\u009f\u00a2\u00a7\u00ad\u00b0\u00b3\u00b8\u00bd\u00c2" +
                    "\u00c4\u00ca\u00cf\u00d5\u00db\u00e1\u00e7\u00e9\u00f0\u00fb\u0107\u010c" +
                    "\u0111\u0001\u0000\u0001\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}