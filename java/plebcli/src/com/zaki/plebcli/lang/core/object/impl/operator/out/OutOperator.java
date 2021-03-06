package com.zaki.plebcli.lang.core.object.impl.operator.out;

import com.zaki.plebcli.cli.exception.InvalidDefinitionException;
import com.zaki.plebcli.cli.memory.LocalObjectHolder;
import com.zaki.plebcli.lang.Keywords;
import com.zaki.plebcli.lang.core.expression.ExpressionEvaluator;
import com.zaki.plebcli.lang.core.object.impl.base.Primitive;
import com.zaki.plebcli.lang.core.object.impl.base.Void;
import com.zaki.plebcli.lang.core.object.impl.operator.Operator;

public class OutOperator extends Operator {

    private String expression;

    public OutOperator(String expression) throws InvalidDefinitionException {
        super(Keywords.OUT);
        build(expression);
    }

    private void build(String expression) {
        this.expression = expression;
    }

    @Override
    public Primitive operate(LocalObjectHolder memory) throws InvalidDefinitionException {
        System.out.println(new ExpressionEvaluator().evaluate(memory, expression));
        return new Void();
    }
}
