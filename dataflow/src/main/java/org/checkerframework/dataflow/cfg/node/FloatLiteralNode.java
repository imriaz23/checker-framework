package org.checkerframework.dataflow.cfg.node;

import com.sun.source.tree.LiteralTree;
import com.sun.source.tree.Tree;
import java.util.Collection;
import java.util.Collections;

/**
 * A node for a float literal. For example:
 *
 * <pre>
 *   <em>8.0f</em>
 *   <em>6.022137e+23F</em>
 * </pre>
 */
public class FloatLiteralNode extends ValueLiteralNode {

    public FloatLiteralNode(LiteralTree t) {
        super(t);
        assert t.getKind().equals(Tree.Kind.FLOAT_LITERAL);
    }

    @Override
    public Float getValue() {
        return (Float) tree.getValue();
    }

    @Override
    public <R, P> R accept(NodeVisitor<R, P> visitor, P p) {
        return visitor.visitFloatLiteral(this, p);
    }

    @Override
    public boolean equals(Object obj) {
        // test that obj is a FloatLiteralNode
        if (obj == null || !(obj instanceof FloatLiteralNode)) {
            return false;
        }
        // super method compares values
        return super.equals(obj);
    }

    @Override
    public Collection<Node> getOperands() {
        return Collections.emptyList();
    }
}