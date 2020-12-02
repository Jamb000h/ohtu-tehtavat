/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonne
 */
public class QueryBuilder {
    
    List<Matcher> m;
    public QueryBuilder() {
        this.m = new ArrayList<>();
    }
    
    public Matcher build() {
        Matcher[] ms = this.m.toArray(new Matcher[0]);
        this.m.clear();
        return new And(ms);
    }
    
    public QueryBuilder playsIn(String team) {
        this.m.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.m.add(new Or(matchers));
        return this;
    }
}
