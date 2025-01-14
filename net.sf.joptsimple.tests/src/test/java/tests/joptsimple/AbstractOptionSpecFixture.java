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

import joptsimple.AbstractOptionSpec;
import joptsimple.OptionSpec;
import joptsimple.OptionSpecBuilder;
import org.infinitest.toolkit.EqualsHashCodeTestSupport;
import org.junit.Test;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public abstract class AbstractOptionSpecFixture<S extends OptionSpec<?>> extends EqualsHashCodeTestSupport {
    @Override
    protected S equal() {
        return createEqualOptionSpecInstance();
    }

    @Override
    protected S notEqual() {
        return createNotEqualOptionSpecInstance();
    }

    protected abstract S createEqualOptionSpecInstance();

    protected abstract S createNotEqualOptionSpecInstance();

    @Test( expected = NullPointerException.class )
    public final void valuesWithNullOptionSet() {
        createEqualOptionSpecInstance().values( null );
    }

    @Test( expected = NullPointerException.class )
    public final void valueWithNullOptionSet() {
        createNotEqualOptionSpecInstance().value( null );
    }

    @Test( expected = NullPointerException.class )
    public final void valueOptionalWithNullOptionSet() {
        createNotEqualOptionSpecInstance().valueOptional( null );
    }
}
