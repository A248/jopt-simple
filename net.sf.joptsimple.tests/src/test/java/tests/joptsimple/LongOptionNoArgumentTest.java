/*
 The MIT License

 Copyright (c) 2004-2016 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package tests.joptsimple;

import static java.util.Collections.*;

import joptsimple.OptionException;
import joptsimple.OptionSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class LongOptionNoArgumentTest extends AbstractOptionParserFixture {
    @Before
    public final void initializeParser() {
        parser.accepts( "verbose" );
        parser.accepts( "verb" );
    }

    @Test
    public void singleLongOption() {
        OptionSet options = parser.parse( "--verbose" );

        assertTrue( options.has( "verbose" ) );
        assertEquals( emptyList(), options.valuesOf( "verbose" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void singleLongOptionAbbreviated() {
        OptionSet options = parser.parse( "--verbo" );

        assertTrue( options.has( "verbose" ) );
        assertFalse( options.has( "verb" ) );
        assertEquals( emptyList(), options.valuesOf( "verbose" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void abbreviationIsALegalOption() {
        OptionSet options = parser.parse( "--verb" );

        assertFalse( options.has( "verbose" ) );
        assertTrue( options.has( "verb" ) );
        assertEquals( emptyList(), options.valuesOf( "verb" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void ambiguousAbbreviation() {
        thrown.expect( OptionException.class );
        thrown.expect( ExceptionMatchers.withOption( "ver" ) );

        parser.parse( "--ver" );
    }
}
