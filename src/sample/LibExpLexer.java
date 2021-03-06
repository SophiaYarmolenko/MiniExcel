// Generated from D:/Programming/MiniExcel/src/sample\LibExp.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LibExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, DOUBLE=2, PI=3, E=4, POW=5, NL=6, WS=7, ID=8, PLUS=9, EQUAL=10, 
		MINUS=11, MULT=12, DIV=13, MOD=14, LPAR=15, RPAR=16, INTDIV=17, LESSEQUAL=18, 
		BIGGEREQUAL=19, BIGGER=20, LESS=21, NOT=22, NOTEQUAL=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "DOUBLE", "PI", "E", "POW", "NL", "WS", "ID", "PLUS", "EQUAL", 
			"MINUS", "MULT", "DIV", "MOD", "LPAR", "RPAR", "INTDIV", "LESSEQUAL", 
			"BIGGEREQUAL", "BIGGER", "LESS", "NOT", "NOTEQUAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'pi'", "'e'", "'^'", "'\n'", null, null, "'+'", "'='", 
			"'-'", "'*'", "'/'", "'%'", "'('", "')'", "':'", "'<='", "'>='", "'>'", 
			"'<'", "'!'", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "DOUBLE", "PI", "E", "POW", "NL", "WS", "ID", "PLUS", "EQUAL", 
			"MINUS", "MULT", "DIV", "MOD", "LPAR", "RPAR", "INTDIV", "LESSEQUAL", 
			"BIGGEREQUAL", "BIGGER", "LESS", "NOT", "NOTEQUAL"
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


	public LibExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LibExp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\6\2\63"+
		"\n\2\r\2\16\2\64\3\3\6\38\n\3\r\3\16\39\3\3\3\3\6\3>\n\3\r\3\16\3?\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\bL\n\b\r\b\16\bM\3\b\3\b\3\t\3"+
		"\t\7\tT\n\t\f\t\16\tW\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\3\2\6\3\2\62;\5\2\13\13\17\17\"\"\5\2C\\aac|\6\2\62"+
		";C\\aac|\2}\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\3\62\3\2\2\2\5\67\3\2\2\2\7A\3\2\2\2\tD\3\2\2\2\13F\3\2\2"+
		"\2\rH\3\2\2\2\17K\3\2\2\2\21Q\3\2\2\2\23X\3\2\2\2\25Z\3\2\2\2\27\\\3\2"+
		"\2\2\31^\3\2\2\2\33`\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2!f\3\2\2\2#h\3\2\2"+
		"\2%j\3\2\2\2\'m\3\2\2\2)p\3\2\2\2+r\3\2\2\2-t\3\2\2\2/v\3\2\2\2\61\63"+
		"\t\2\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\4"+
		"\3\2\2\2\668\t\2\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3"+
		"\2\2\2;=\7\60\2\2<>\t\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\6"+
		"\3\2\2\2AB\7r\2\2BC\7k\2\2C\b\3\2\2\2DE\7g\2\2E\n\3\2\2\2FG\7`\2\2G\f"+
		"\3\2\2\2HI\7\f\2\2I\16\3\2\2\2JL\t\3\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2"+
		"MN\3\2\2\2NO\3\2\2\2OP\b\b\2\2P\20\3\2\2\2QU\t\4\2\2RT\t\5\2\2SR\3\2\2"+
		"\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\22\3\2\2\2WU\3\2\2\2XY\7-\2\2Y\24\3"+
		"\2\2\2Z[\7?\2\2[\26\3\2\2\2\\]\7/\2\2]\30\3\2\2\2^_\7,\2\2_\32\3\2\2\2"+
		"`a\7\61\2\2a\34\3\2\2\2bc\7\'\2\2c\36\3\2\2\2de\7*\2\2e \3\2\2\2fg\7+"+
		"\2\2g\"\3\2\2\2hi\7<\2\2i$\3\2\2\2jk\7>\2\2kl\7?\2\2l&\3\2\2\2mn\7@\2"+
		"\2no\7?\2\2o(\3\2\2\2pq\7@\2\2q*\3\2\2\2rs\7>\2\2s,\3\2\2\2tu\7#\2\2u"+
		".\3\2\2\2vw\7#\2\2wx\7?\2\2x\60\3\2\2\2\b\2\649?MU\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}