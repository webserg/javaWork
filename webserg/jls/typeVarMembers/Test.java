package webserg.jls.typeVarMembers;

interface I {
    void mI();
}

/**
 * User: webserg
 * Date: 21.11.12
 * <p/>
 * A type variable is an unqualified identifier used as a type in class, interface, method,
 * and constructor bodies.
 * Every type variable declared as a type parameter has a bound. If no bound is
 * declared for a type variable, Object is assumed. If a bound is declared, it consists
 * of either:
 * • a single type variable T, or
 * • a class or interface type T possibly followed by interface types I1 & ... & In.
 * has the same members as the empty class CT, defined in the same scope with equivalent
 * supertypes. The members of an interface are always public, and therefore always inherited
 * (unless overridden). Hence mI is a member of CT and of T. Among the members of C, all
 * but mCPrivate are inherited by CT, and are therefore members of both CT and T.
 * If C had been declared in a different package than T, then the call to mCDefault would
 * give rise to a compile-time error, as that member would not be accessible at the point where
 * T is declared.
 */
class C {
    public void mCPublic() {
    }

    protected void mCProtected() {
    }

    void mCDefault() {
    }

    private void mCPrivate() {
    }
}

class CT extends C implements I {
    public void mI() {
    }
}

public class Test {
    <T extends C & I> void test(T t) {
        t.mI(); // OK
        t.mCPublic(); // OK
        t.mCProtected(); // OK
        t.mCDefault(); // OK
        // t.mCPrivate(); // Compile-time error
    }
}