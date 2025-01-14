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

import joptsimple.ValueConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class ValueConverterAdmitsSubclassesOfValueTypeTest {
    @Test
    public void subclassOfValueType() {
        ValueConverter<List<String>> converter = new ValueConverter<List<String>>() {
            @Override
            public List<String> convert( String value ) {
                return singletonList( value );
            }

            @Override
            public String revert( Object value ) {
                return valueType().cast( value ).get( 0 );
            }

            @Override
            public Class<? extends List<String>> valueType() {
                return ListOfStrings.class;
            }

            @Override
            public String valuePattern() {
                return null;
            }
        };

        assertEquals( singletonList( "foo" ), converter.convert( "foo" ) );
    }

    static class ListOfStrings extends ArrayList<String> {
        private static final long serialVersionUID = 1L;
    }
}
