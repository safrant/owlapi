/* TurtleParser.java */
/* Generated By:JavaCC: Do not edit this line. TurtleParser.java */
package org.semanticweb.owlapi.rdf.turtle.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.NodeID;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.util.EscapeUtils;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semanticweb.owlapi.vocab.XSDVocabulary;

/**
 * The Class TurtleParser.
 */
@SuppressWarnings("all")
public class TurtleParser implements TurtleParserConstants {

    static private int[] jj_la1_0;
    static private int[] jj_la1_1;

    static {
        jj_la1_init_0();
        jj_la1_init_1();
    }

    final private int[] jj_la1 = new int[21];
    final private JJCalls[] jj_2_rtns = new JJCalls[3];
    final private LookaheadSuccess jj_ls = new LookaheadSuccess();
    /**
     * Generated Token Manager.
     */
    public TurtleParserTokenManager token_source;
    /**
     * Current token.
     */
    public Token token;
    /**
     * Next token.
     */
    public Token jj_nt;
    JavaCharStream jj_input_stream;
    private Map<String, IRI> string2IRI;
    private IRI base;
    private TripleHandler handler;
    private PrefixManager pm = new DefaultPrefixManager();
    private int jj_ntk;
    private Token jj_scanpos, jj_lastpos;
    private int jj_la;
    private int jj_gen;
    private boolean jj_rescan = false;
    private int jj_gc = 0;
    private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;
    private int trace_indent = 0;
    private boolean trace_enabled;

    /**
     * Instantiates a new turtle parser.
     *
     * @param reader the reader
     * @param handler the handler
     * @param base the base
     */
    public TurtleParser(Reader reader, TripleHandler handler, IRI base) throws IOException {
        this(new StreamProvider(reader));
        this.handler = handler;
        this.base = base;
        string2IRI = new HashMap<String, IRI>();
        pm.setDefaultPrefix("http://www.semanticweb.org/owl/owlapi/turtle#");
    }

    /**
     * Instantiates a new turtle parser.
     *
     * @param is the is
     * @param handler the handler
     * @param base the base
     */
    public TurtleParser(InputStream is, TripleHandler handler, IRI base) throws IOException {
        this(new StreamProvider(is));
        this.handler = handler;
        this.base = base;
        string2IRI = new HashMap<String, IRI>();
        pm.setDefaultPrefix("http://www.semanticweb.org/owl/owlapi/turtle#");
    }

    /**
     * Constructor.
     */
    public TurtleParser(Provider stream) {
        jj_input_stream = new JavaCharStream(stream, 1, 1);
        token_source = new TurtleParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Constructor.
     */
    public TurtleParser(String dsl) throws ParseException, TokenMgrException {
        this(new StringProvider(dsl));
    }

    /**
     * Constructor with generated Token Manager.
     */
    public TurtleParser(TurtleParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x28000000, 0x28000000, 0x0, 0x0, 0x28000000, 0x0, 0x0, 0x28000000,
            0x0, 0x0, 0x0, 0x80000000, 0x28000000, 0x2be22200, 0x2be22200, 0x0, 0x0, 0x3e22200,
            0xc00000, 0x0, 0x222200,};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0x858094, 0x858094, 0x14, 0x58040, 0x858080, 0x1, 0x58040, 0x800080,
            0x2, 0x58040, 0x8000, 0x0, 0x858080, 0x858680, 0x858680, 0x28, 0x28, 0x600, 0x0, 0x600,
            0x0,};
    }

    /**
     * Gets the prefix manager.
     *
     * @return the prefix manager
     */
    public PrefixManager getPrefixManager() {
        return pm;
    }

    /**
     * Sets the triple handler.
     *
     * @param handler the new triple handler
     */
    public void setTripleHandler(TripleHandler handler) {
        this.handler = handler;
    }

    /**
     * Gets the next blank node.
     *
     * @param id the id
     * @return the next blank node
     */
    protected IRI getNextBlankNode(String id) {
        String string;
        if (id == null) {
            string = NodeID.nextAnonymousIRI();
        } else {
            if (NodeID.isAnonymousNodeID(id)) {
                string = id;
            } else {
                string = NodeID.getIRIFromNodeID(id);
            }
        }
        IRI iri = string2IRI.get(string);
        if (iri == null) {
            iri = IRI.create(string);
            string2IRI.put(string, iri);
        }
        return iri;
    }

    /**
     * Gets the iRI from q name.
     *
     * @param qname the qname
     * @return the iRI from q name
     * @throws ParseException the parse exception
     */
    protected IRI getIRIFromQName(String qname) throws ParseException {
        int colonIndex = qname.indexOf(':');
        if (colonIndex == -1) {
            throw new ParseException("Not a valid qname (missing ':') " + qname);
        }
        String prefix = qname.substring(0, colonIndex + 1);
        if (prefix.equals("_:")) {
            return getIRI("genid" + qname.substring(colonIndex + 1));
        }
        if (!pm.containsPrefixMapping(prefix)) {
            throw new ParseException("Prefix not declared: " + prefix);
        }
        return pm.getIRI(qname);
    }

    /**
     * Gets the iri.
     *
     * @param s the s
     * @return the iri
     */
    public IRI getIRI(String s) {
        if (s.charAt(0) == '<') {
            s = s.substring(1, s.length() - 1);
        }
        IRI iri = string2IRI.get(s);
        if (iri == null) {
            iri = IRI.create(s);
            if (!iri.isAbsolute()) {
                iri = IRI.create(
                    base.getNamespace().substring(0, base.getNamespace().lastIndexOf('/') + 1), s);
            }
            string2IRI.put(s, iri);
        }
        return iri;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    final public void parseDocument() throws ParseException {
        label_1:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case PREFIX:
                case BASE: {
                    parseDirective();
                    jj_consume_token(DOT);
                    break;
                }
                case OPENPAR:
                case OPEN_SQUARE_BRACKET:
                case EMPTY_BLANK_NODE:
                case FULLIRI:
                case PNAME_NS:
                case PNAME_LN:
                case NODEID: {
                    parseStatement();
                    jj_consume_token(DOT);
                    break;
                }
                default:
                    jj_la1[0] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case OPENPAR:
                case OPEN_SQUARE_BRACKET:
                case PREFIX:
                case BASE:
                case EMPTY_BLANK_NODE:
                case FULLIRI:
                case PNAME_NS:
                case PNAME_LN:
                case NODEID: {
                    ;
                    break;
                }
                default:
                    jj_la1[1] = jj_gen;
                    break label_1;
            }
        }
        jj_consume_token(0);
        handler.handleEnd();
    }

    final public void parseDirective() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case PREFIX: {
                parsePrefixDirective();
                break;
            }
            case BASE: {
                parseBaseDirective();
                break;
            }
            default:
                jj_la1[2] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void parsePrefixDirective() throws ParseException {
        Token t;
        IRI ns;
        jj_consume_token(PREFIX);
        t = jj_consume_token(PNAME_NS);
        ns = parseIRI();
        pm.setPrefix(t.image, ns.toString());
        handler.handlePrefixDirective(t.image, ns.toString());
    }

    final public void parseBaseDirective() throws ParseException {
        Token t;
        jj_consume_token(BASE);
        t = jj_consume_token(FULLIRI);
        base = IRI.create(t.image.substring(1, t.image.length() - 1));
        handler.handleBaseDirective(base);
    }

    final public void parseStatement() throws ParseException {
        parseTriples();
    }

    final public void parseTriples() throws ParseException {
        IRI subject;
        subject = parseSubject();
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case A:
            case FULLIRI:
            case PNAME_NS:
            case PNAME_LN: {
                parsePredicateObjectList(subject);
                break;
            }
            default:
                jj_la1[3] = jj_gen;
                ;
        }
    }

    final public IRI parseSubject() throws ParseException {
        IRI iri;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case FULLIRI:
            case PNAME_NS:
            case PNAME_LN: {
                iri = parseResource();
                break;
            }
            case OPENPAR:
            case OPEN_SQUARE_BRACKET:
            case EMPTY_BLANK_NODE:
            case NODEID: {
                iri = parseBlankNode();
                break;
            }
            default:
                jj_la1[4] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return iri;
    }

    final public IRI parseLoneNS() throws ParseException {
        Token t;
        t = jj_consume_token(PNAME_NS);
        return getIRIFromQName(t.image);
    }

    final public IRI parseAbbreviatedIRI() throws ParseException {
        Token t;
        t = jj_consume_token(PNAME_LN);
        return getIRIFromQName(t.image);
    }

    final public IRI parseIRI() throws ParseException {
        Token t;
        t = jj_consume_token(FULLIRI);
        return getIRI(t.image);
    }

    final public IRI parseBlankNode() throws ParseException {
        IRI iri = null;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case NODEID: {
                iri = parseNodeID();
                break;
            }
            case EMPTY_BLANK_NODE: {
                jj_consume_token(EMPTY_BLANK_NODE);
                if (iri == null) {
                    iri = getNextBlankNode(null);
                }
                break;
            }
            case OPEN_SQUARE_BRACKET: {
                jj_consume_token(OPEN_SQUARE_BRACKET);
                switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                    case A:
                    case FULLIRI:
                    case PNAME_NS:
                    case PNAME_LN: {
                        if (iri == null) {
                            iri = getNextBlankNode(null);
                        }
                        parsePredicateObjectList(iri);
                        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                            case DOT: {
                                jj_consume_token(DOT);
                                break;
                            }
                            default:
                                jj_la1[5] = jj_gen;
                                ;
                        }
                        break;
                    }
                    default:
                        jj_la1[6] = jj_gen;
                        ;
                }
                jj_consume_token(CLOSE_SQUARE_BRACKET);
                if (iri == null) {
                    iri = getNextBlankNode(null);
                }
                break;
            }
            case OPENPAR: {
                iri = parseCollection();
                break;
            }
            default:
                jj_la1[7] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return iri;
    }

    final public IRI parseNodeID() throws ParseException {
        Token t;
        t = jj_consume_token(NODEID);
        return getNextBlankNode(t.image);
    }

    final public void parsePredicateObjectList(IRI subject) throws ParseException {
        IRI predicate;
        predicate = parseVerb();
        parseObjectList(subject, predicate);
        label_2:
        while (true) {
            if (jj_2_1(2)) {
                ;
            } else {
                break label_2;
            }
            jj_consume_token(SEMICOLON);
            predicate = parseVerb();
            parseObjectList(subject, predicate);
        }
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case SEMICOLON: {
                jj_consume_token(SEMICOLON);
                break;
            }
            default:
                jj_la1[8] = jj_gen;
                ;
        }
    }

    final public IRI parseVerb() throws ParseException {
        IRI iri;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case A: {
                jj_consume_token(A);
                iri = OWLRDFVocabulary.RDF_TYPE.getIRI();
                break;
            }
            case FULLIRI:
            case PNAME_NS:
            case PNAME_LN: {
                iri = parsePredicate();
                break;
            }
            default:
                jj_la1[9] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return iri;
    }

    final public IRI parsePredicate() throws ParseException {
        IRI iri;
        iri = parseResource();
        return iri;
    }

    final public IRI parseResource() throws ParseException {
        IRI iri;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case FULLIRI: {
                iri = parseIRI();
                break;
            }
            default:
                jj_la1[10] = jj_gen;
                if (jj_2_2(2)) {
                    iri = parseAbbreviatedIRI();
                } else if (jj_2_3(2)) {
                    iri = parseLoneNS();
                } else {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
        }
        return iri;
    }

    final public void parseObjectList(IRI subject, IRI predicate) throws ParseException {
        parseObject(subject, predicate);
        label_3:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case COMMA: {
                    ;
                    break;
                }
                default:
                    jj_la1[11] = jj_gen;
                    break label_3;
            }
            jj_consume_token(COMMA);
            parseObject(subject, predicate);
        }
    }

    final public void parseObject(IRI subject, IRI predicate) throws ParseException {
        IRI resObject;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case STRING:
            case SINGLESTRING:
            case LONG_STRING:
            case LONG_SINGLESTRING:
            case DIGIT:
            case INTEGER:
            case DOUBLE:
            case DECIMAL:
            case TRUE:
            case FALSE: {
                parseLiteral(subject, predicate);
                break;
            }
            case OPENPAR:
            case OPEN_SQUARE_BRACKET:
            case EMPTY_BLANK_NODE:
            case FULLIRI:
            case PNAME_NS:
            case PNAME_LN:
            case NODEID: {
                switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                    case FULLIRI:
                    case PNAME_NS:
                    case PNAME_LN: {
                        resObject = parseResource();
                        break;
                    }
                    case OPENPAR:
                    case OPEN_SQUARE_BRACKET:
                    case EMPTY_BLANK_NODE:
                    case NODEID: {
                        resObject = parseBlankNode();
                        break;
                    }
                    default:
                        jj_la1[12] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                handler.handleTriple(subject, predicate, resObject);
                break;
            }
            default:
                jj_la1[13] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public IRI parseCollection() throws ParseException {
        IRI iri;
        jj_consume_token(OPENPAR);
        iri = parseItemList();
        jj_consume_token(CLOSEPAR);
        return iri;
    }

    final public IRI parseItemList() throws ParseException {//  _x  rdf:type rdf:List
        //  _x  rdf:first
        //  _x  rdf:next
        IRI firstSubject = OWLRDFVocabulary.RDF_NIL.getIRI();
        IRI subject = null;
        IRI type = OWLRDFVocabulary.RDF_TYPE.getIRI();
        IRI first = OWLRDFVocabulary.RDF_FIRST.getIRI();
        IRI rest = OWLRDFVocabulary.RDF_REST.getIRI();
        IRI list = OWLRDFVocabulary.RDF_LIST.getIRI();
        IRI nil = OWLRDFVocabulary.RDF_NIL.getIRI();
        label_4:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case STRING:
                case SINGLESTRING:
                case LONG_STRING:
                case LONG_SINGLESTRING:
                case DIGIT:
                case INTEGER:
                case DOUBLE:
                case DECIMAL:
                case OPENPAR:
                case OPEN_SQUARE_BRACKET:
                case EMPTY_BLANK_NODE:
                case TRUE:
                case FALSE:
                case FULLIRI:
                case PNAME_NS:
                case PNAME_LN:
                case NODEID: {
                    ;
                    break;
                }
                default:
                    jj_la1[14] = jj_gen;
                    break label_4;
            }
            IRI prevSubject = subject;
            subject = getNextBlankNode(null);
            if (prevSubject != null) {
                handler.handleTriple(prevSubject, rest, subject);
            } else {
                firstSubject = subject;
            }
            if (subject != null) {
                handler.handleTriple(subject, type, list);
            }
            parseObject(subject, first);
        }
// Terminate list
        if (subject != null) {
            handler.handleTriple(subject, rest, nil);
        }
        return firstSubject;
    }

    final public void parseLiteral(IRI subject, IRI predicate) throws ParseException {
        String literal;
        String lang = null;
        IRI datatype = null;
        Token t;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case STRING:
            case SINGLESTRING:
            case LONG_STRING:
            case LONG_SINGLESTRING: {
                literal = parseQuotedString();
                switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                    case DOUBLE_CARET:
                    case AT: {
                        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                            case DOUBLE_CARET: {
                                jj_consume_token(DOUBLE_CARET);
                                datatype = parseResource();
                                break;
                            }
                            case AT: {
                                jj_consume_token(AT);
                                t = jj_consume_token(PN_LOCAL);
                                lang = t.image;
                                break;
                            }
                            default:
                                jj_la1[15] = jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                        }
                        break;
                    }
                    default:
                        jj_la1[16] = jj_gen;
                        ;
                }
                if (datatype != null) {
                    handler.handleTriple(subject, predicate, literal, datatype);
                } else if (lang != null) {
                    handler.handleTriple(subject, predicate, literal, lang);
                } else {
                    handler.handleTriple(subject, predicate, literal);
                }
                break;
            }
            case DIGIT:
            case INTEGER: {
                literal = parseInteger();
                handler.handleTriple(subject, predicate, literal, XSDVocabulary.INTEGER.getIRI());
                break;
            }
            case DOUBLE: {
                literal = parseDouble();
                handler.handleTriple(subject, predicate, literal, XSDVocabulary.DOUBLE.getIRI());
                break;
            }
            case DECIMAL: {
                literal = parseDecimal();
                handler.handleTriple(subject, predicate, literal, XSDVocabulary.DECIMAL.getIRI());
                break;
            }
            case TRUE:
            case FALSE: {
                literal = parseBoolean();
                handler.handleTriple(subject, predicate, literal, XSDVocabulary.BOOLEAN.getIRI());
                break;
            }
            default:
                jj_la1[17] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public String parseInteger() throws ParseException {
        Token t;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case INTEGER: {
                t = jj_consume_token(INTEGER);
                break;
            }
            case DIGIT: {
                t = jj_consume_token(DIGIT);
                break;
            }
            default:
                jj_la1[18] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return t.image;
    }

    final public String parseDouble() throws ParseException {
        Token t;
        t = jj_consume_token(DOUBLE);
        return t.image;
    }

    final public String parseDecimal() throws ParseException {
        Token t;
        t = jj_consume_token(DECIMAL);
        return t.image;
    }

    final public String parseBoolean() throws ParseException {
        Token t;
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case TRUE: {
                t = jj_consume_token(TRUE);
                break;
            }
            case FALSE: {
                t = jj_consume_token(FALSE);
                break;
            }
            default:
                jj_la1[19] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return t.image;
    }

    final public String parseQuotedString() throws ParseException {
        String s;
        s = parseString();
        return s;
    }

    final public String parseString() throws ParseException {
        Token t;
        String rawString = "";
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case STRING: {
                t = jj_consume_token(STRING);
                rawString = t.image.substring(1, t.image.length() - 1);
                break;
            }
            case SINGLESTRING: {
                t = jj_consume_token(SINGLESTRING);
                rawString = t.image.substring(1, t.image.length() - 1);
                break;
            }
            case LONG_STRING: {
                t = jj_consume_token(LONG_STRING);
                rawString = t.image.substring(3, t.image.length() - 3);
                break;
            }
            case LONG_SINGLESTRING: {
                t = jj_consume_token(LONG_SINGLESTRING);
                rawString = t.image.substring(3, t.image.length() - 3);
                break;
            }
            default:
                jj_la1[20] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return EscapeUtils.unescapeString(rawString);
    }

    private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return (!jj_3_1());
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(0, xla);
        }
    }

    private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return (!jj_3_2());
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(1, xla);
        }
    }

    private boolean jj_2_3(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return (!jj_3_3());
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(2, xla);
        }
    }

    private boolean jj_3R_6() {
        if (jj_scan_token(PNAME_LN)) {
            return true;
        }
        return false;
    }

    private boolean jj_3_3() {
        if (jj_3R_7()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_7() {
        if (jj_scan_token(PNAME_NS)) {
            return true;
        }
        return false;
    }

    private boolean jj_3_1() {
        if (jj_scan_token(SEMICOLON)) {
            return true;
        }
        if (jj_3R_5()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_12() {
        if (jj_3R_13()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_11() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_12()) {
            jj_scanpos = xsp;
            if (jj_3_2()) {
                jj_scanpos = xsp;
                if (jj_3_3()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean jj_3R_10() {
        if (jj_3R_11()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_9() {
        if (jj_3R_10()) {
            return true;
        }
        return false;
    }

    private boolean jj_3_2() {
        if (jj_3R_6()) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_13() {
        if (jj_scan_token(FULLIRI)) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_8() {
        if (jj_scan_token(A)) {
            return true;
        }
        return false;
    }

    private boolean jj_3R_5() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_8()) {
            jj_scanpos = xsp;
            if (jj_3R_9()) {
                return true;
            }
        }
        return false;
    }

    public void ReInit(String s) {
        ReInit(new StringProvider(s));
    }

    /**
     * Reinitialise.
     */
    public void ReInit(Provider stream) {
        if (jj_input_stream == null) {
            jj_input_stream = new JavaCharStream(stream, 1, 1);
        } else {
            jj_input_stream.ReInit(stream, 1, 1);
        }
        if (token_source == null) {
            token_source = new TurtleParserTokenManager(jj_input_stream);
        }

        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(TurtleParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) {
            jj_la1[i] = -1;
        }
        for (int i = 0; i < jj_2_rtns.length; i++) {
            jj_2_rtns[i] = new JJCalls();
        }
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen) {
                            c.first = null;
                        }
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0;
            Token tok = token;
            while (tok != null && tok != jj_scanpos) {
                i++;
                tok = tok.next;
            }
            if (tok != null) {
                jj_add_error_token(kind, i);
            }
        }
        if (jj_scanpos.kind != kind) {
            return true;
        }
        if (jj_la == 0 && jj_scanpos == jj_lastpos) {
            throw jj_ls;
        }
        return false;
    }

    /**
     * Get the next Token.
     */
    final public Token getNextToken() {
        if (token.next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /**
     * Get the specific Token.
     */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) {
                t = t.next;
            } else {
                t = t.next = token_source.getNextToken();
            }
        }
        return t;
    }

    private int jj_ntk_f() {
        if ((jj_nt = token.next) == null) {
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        } else {
            return (jj_ntk = jj_nt.kind);
        }
    }

    private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100) {
            return;
        }

        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];

            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }

            for (int[] oldentry : jj_expentries) {
                if (oldentry.length == jj_expentry.length) {
                    boolean isMatched = true;

                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            isMatched = false;
                            break;
                        }

                    }
                    if (isMatched) {
                        jj_expentries.add(jj_expentry);
                        break;
                    }
                }
            }

            if (pos != 0) {
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
            }
        }
    }

    /**
     * Generate ParseException.
     */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[57];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 21; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                    if ((jj_la1_1[i] & (1 << j)) != 0) {
                        la1tokens[32 + j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 57; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage, token_source == null ? null
            : TurtleParserTokenManager.lexStateNames[token_source.curLexState]);
    }

    /**
     * Trace enabled.
     */
    final public boolean trace_enabled() {
        return trace_enabled;
    }

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 3; i++) {
            try {
                JJCalls p = jj_2_rtns[i];

                do {
                    if (p.gen > jj_gen) {
                        jj_la = p.arg;
                        jj_lastpos = jj_scanpos = p.first;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                        }
                    }
                    p = p.next;
                } while (p != null);

            } catch (LookaheadSuccess ls) {
            }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }

        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    @SuppressWarnings("serial")
    static private final class LookaheadSuccess extends java.lang.RuntimeException {

    }

    static final class JJCalls {

        int gen;
        Token first;
        int arg;
        JJCalls next;
    }

}
