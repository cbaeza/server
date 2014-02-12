package com.cbaeza.model.commons.ws.session;

import com.cbaeza.model.commons.ws.WS;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public class WSSessionTokens implements WS {

    private List<WSSessionToken> list;

    public WSSessionTokens() {
        this.list = new ArrayList<WSSessionToken>(0);
    }

    public WSSessionTokens(List<WSSessionToken> list) {
        this.list = list;
    }

    public List<WSSessionToken> getList() {
        return list;
    }

    public void setList(List<WSSessionToken> list) {
        this.list = list;
    }
}
