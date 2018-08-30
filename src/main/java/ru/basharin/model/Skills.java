package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Skills extends BaseEntity implements Serializable {

    private String java;
    private String hibernate;
    private String SQL;
    private String maven;
    private String JDBC;
    private String spring;
    private String git;

    public Skills(long id) {
        super(id);
        this.java = null;
        this.hibernate = null;
        this.SQL = null;
        this.maven = null;
        this.JDBC = null;
        this.spring = null;
        this.git = null;
    }

    public Skills(long id, String java, String hibernate, String SQL, String maven, String JDBC, String spring, String git) {
        super(id);
        this.java = java;
        this.hibernate = hibernate;
        this.SQL = SQL;
        this.maven = maven;
        this.JDBC = JDBC;
        this.spring = spring;
        this.git = git;
    }

    public String getJava() {
        return java;
    }

    public String getHibernate() {
        return hibernate;
    }

    public String getSQL() {
        return SQL;
    }

    public String getMaven() {
        return maven;
    }

    public String getJDBC() {
        return JDBC;
    }

    public String getSpring() {
        return spring;
    }

    public String getGit() {
        return git;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public void setHibernate(String hibernate) {
        this.hibernate = hibernate;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    public void setMaven(String maven) {
        this.maven = maven;
    }

    public void setJDBC(String JDBC) {
        this.JDBC = JDBC;
    }

    public void setSpring(String spring) {
        this.spring = spring;
    }

    public void setGit(String git) {
        this.git = git;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Skills skills = (Skills) o;
        return Objects.equals(java, skills.java) &&
                Objects.equals(hibernate, skills.hibernate) &&
                Objects.equals(SQL, skills.SQL) &&
                Objects.equals(maven, skills.maven) &&
                Objects.equals(JDBC, skills.JDBC) &&
                Objects.equals(spring, skills.spring) &&
                Objects.equals(git, skills.git);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), java, hibernate, SQL, maven, JDBC, spring, git);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "java='" + java + '\'' +
                ", hibernate='" + hibernate + '\'' +
                ", SQL='" + SQL + '\'' +
                ", maven='" + maven + '\'' +
                ", JDBC='" + JDBC + '\'' +
                ", spring='" + spring + '\'' +
                ", git='" + git + '\'' +
                '}';
    }
}
