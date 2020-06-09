/* Generated By:JavaCC: Do not edit this line. Parser.java */
package edu.itsco;

public class Parser implements ParserConstants {
  public static void main(String args []) throws ParseException
  {
    Parser parser = new Parser(System.in);
   System.out.println ("bienvenidos al COMPILADOR");
   System.out.println ("----------------------------------------------");
   Parser.principal();
   System.out.println ("EL PROGRAMA SE COMPILO CORRECTAMENTE");

  }

  static final public void principal() throws ParseException {
    jj_consume_token(INICIO);
    jj_consume_token(ID);
    sentencias();
    jj_consume_token(FIN);
  }

  static final public void sentencias() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINT:
        gramaticaImprimir();
        break;
      case VAR:
        declararVariable();
        break;
      case INPUT:
        gramaticaLeer();
        break;
      case IF:
        gramaticaIf();
        break;
      case WHILE:
        gramaticaWhile();
        break;
      case ID:
        gramaticaAsignacion();
        break;
      case FOR:
        gramaticaFor();
        break;
      case SELECT:
        gramaticaSelect();
        break;
      case DO:
        gramaticaDo();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
      case PRINT:
      case INPUT:
      case IF:
      case SELECT:
      case FOR:
      case WHILE:
      case DO:
      case ID:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
  }

//Gramaticas
  static final public void gramaticaImprimir() throws ParseException {
    jj_consume_token(PRINT);
    jj_consume_token(AP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALOR_INT:
    case VALOR_FLOAT:
    case VALOR_STRING:
      valor();
      break;
    case ID:
      jj_consume_token(ID);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SUM:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(SUM);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VALOR_INT:
      case VALOR_FLOAT:
      case VALOR_STRING:
        valor();
        break;
      case ID:
        jj_consume_token(ID);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(CP);
  }

  static final public void declararVariable() throws ParseException {
    jj_consume_token(VAR);
    jj_consume_token(ID);
    TipoDato();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IGUAL:
      jj_consume_token(IGUAL);
      valor();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
  }

  static final public void gramaticaLeer() throws ParseException {
    jj_consume_token(INPUT);
    jj_consume_token(AP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case VALOR_INT:
    case VALOR_FLOAT:
    case VALOR_STRING:
      valor();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(CP);
  }

  static final public void gramaticaAsignacion() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(IGUAL);
    operacion();
  }

  static final public void gramaticaIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(AP);
    condicion();
    jj_consume_token(CP);
    jj_consume_token(ENTONCES);
    sentencias();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      sentencias();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    jj_consume_token(FIN);
    jj_consume_token(IF);
  }

  static final public void gramaticaSelect() throws ParseException {
    jj_consume_token(SELECT);
    jj_consume_token(AP);
    jj_consume_token(ID);
    jj_consume_token(CP);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHEN:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_3;
      }
      jj_consume_token(WHEN);
      jj_consume_token(VALOR_INT);
      jj_consume_token(ENTONCES);
      sentencias();
      jj_consume_token(BREAK);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PREDETERMINADO:
      jj_consume_token(PREDETERMINADO);
      jj_consume_token(ENTONCES);
      sentencias();
      jj_consume_token(BREAK);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(FIN);
    jj_consume_token(SELECT);
  }

  static final public void gramaticaFor() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(ID);
    jj_consume_token(IGUAL);
    jj_consume_token(VALOR_INT);
    jj_consume_token(TO);
    jj_consume_token(VALOR_INT);
    jj_consume_token(ENTONCES);
    sentencias();
    jj_consume_token(NEXT);
  }

  static final public void gramaticaWhile() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(AP);
    condicion();
    jj_consume_token(CP);
    jj_consume_token(ENTONCES);
    sentencias();
    jj_consume_token(FIN);
    jj_consume_token(WHILE);
  }

  static final public void gramaticaDo() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(ENTONCES);
    sentencias();
    jj_consume_token(FIN);
    jj_consume_token(WHILE);
    jj_consume_token(AP);
    condicion();
    jj_consume_token(CP);
  }

//cosas
  static final public void TipoDato() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALOR_STRING:
      jj_consume_token(VALOR_STRING);
      break;
    case VALOR_INT:
      jj_consume_token(VALOR_INT);
      break;
    case VALOR_FLOAT:
      jj_consume_token(VALOR_FLOAT);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void operacion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALOR_INT:
    case VALOR_FLOAT:
    case VALOR_STRING:
      valor();
      break;
    case ID:
      jj_consume_token(ID);
      break;
    case AP:
      opParentesis();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SUM:
      case REST:
      case MULT:
      case DIV:
      case MOD:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
      opAritmetico();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VALOR_INT:
      case VALOR_FLOAT:
      case VALOR_STRING:
        valor();
        break;
      case ID:
        jj_consume_token(ID);
        break;
      case AP:
        opParentesis();
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void opParentesis() throws ParseException {
    jj_consume_token(AP);
    operacion();
    jj_consume_token(CP);
  }

  static final public void opAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUM:
      jj_consume_token(SUM);
      break;
    case REST:
      jj_consume_token(REST);
      break;
    case MULT:
      jj_consume_token(MULT);
      break;
    case DIV:
      jj_consume_token(DIV);
      break;
    case MOD:
      jj_consume_token(MOD);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void condicion() throws ParseException {
    condicionSimple();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
      case OR:
      case NOT:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_5;
      }
      opLogico();
      condicionSimple();
    }
  }

  static final public void opLogico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void condicionSimple() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALOR_INT:
    case VALOR_FLOAT:
    case VALOR_STRING:
      valor();
      break;
    case ID:
      jj_consume_token(ID);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    opRelacional();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALOR_INT:
    case VALOR_FLOAT:
    case VALOR_STRING:
      valor();
      break;
    case ID:
      jj_consume_token(ID);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRelacional() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAYOR:
      jj_consume_token(MAYOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        jj_consume_token(IGUAL);
        break;
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      break;
    case MENOR:
      jj_consume_token(MENOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        jj_consume_token(IGUAL);
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      jj_consume_token(IGUAL);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[23];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3113880,0x3113880,0x0,0x4000000,0x0,0x0,0x0,0x8000,0x20000,0x40000,0x700,0x0,0x0,0x7c000000,0x0,0x7c000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x8000,0x8000,0xf000,0x0,0xf000,0x1,0xf000,0x0,0x0,0x0,0x0,0x7000,0xf040,0x0,0xf040,0x0,0x38,0x38,0xf000,0xf000,0x1,0x1,0x7,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[48];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 23; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
