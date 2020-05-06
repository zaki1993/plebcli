package com.zaki.plebcli.lang.core.object.impl.operator.in;

import com.zaki.plebcli.cli.exception.InvalidDefinitionException;
import com.zaki.plebcli.cli.memory.ObjectHolder;
import com.zaki.plebcli.lang.Keywords;
import com.zaki.plebcli.lang.core.object.impl.Operator;
import com.zaki.plebcli.lang.core.object.impl.Variable;
import com.zaki.plebcli.util.CliUtils;

import java.util.Scanner;

public class In extends Operator {

    private String varName;

    public In(String varName) throws InvalidDefinitionException {
        super(Keywords.IN);
        build(varName);
    }

    @Override
    public void operate(ObjectHolder memory) throws InvalidDefinitionException {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        memory.addObject(new Variable(varName, value));
    }

    private void build(String s) throws InvalidDefinitionException {

        if (s.contains(CliUtils.SPACE)) {
            throw new InvalidDefinitionException("Nevalidna stoinost " + s);
        }

        this.varName = s;
    }
}
