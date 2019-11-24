package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.List;

public class WsinforExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WsinforExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWorkshopidIsNull() {
            addCriterion("workshopid is null");
            return (Criteria) this;
        }

        public Criteria andWorkshopidIsNotNull() {
            addCriterion("workshopid is not null");
            return (Criteria) this;
        }

        public Criteria andWorkshopidEqualTo(String value) {
            addCriterion("workshopid =", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidNotEqualTo(String value) {
            addCriterion("workshopid <>", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidGreaterThan(String value) {
            addCriterion("workshopid >", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidGreaterThanOrEqualTo(String value) {
            addCriterion("workshopid >=", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidLessThan(String value) {
            addCriterion("workshopid <", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidLessThanOrEqualTo(String value) {
            addCriterion("workshopid <=", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidLike(String value) {
            addCriterion("workshopid like", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidNotLike(String value) {
            addCriterion("workshopid not like", value, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidIn(List<String> values) {
            addCriterion("workshopid in", values, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidNotIn(List<String> values) {
            addCriterion("workshopid not in", values, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidBetween(String value1, String value2) {
            addCriterion("workshopid between", value1, value2, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopidNotBetween(String value1, String value2) {
            addCriterion("workshopid not between", value1, value2, "workshopid");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameIsNull() {
            addCriterion("workshopname is null");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameIsNotNull() {
            addCriterion("workshopname is not null");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameEqualTo(String value) {
            addCriterion("workshopname =", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameNotEqualTo(String value) {
            addCriterion("workshopname <>", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameGreaterThan(String value) {
            addCriterion("workshopname >", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameGreaterThanOrEqualTo(String value) {
            addCriterion("workshopname >=", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameLessThan(String value) {
            addCriterion("workshopname <", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameLessThanOrEqualTo(String value) {
            addCriterion("workshopname <=", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameLike(String value) {
            addCriterion("workshopname like", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameNotLike(String value) {
            addCriterion("workshopname not like", value, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameIn(List<String> values) {
            addCriterion("workshopname in", values, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameNotIn(List<String> values) {
            addCriterion("workshopname not in", values, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameBetween(String value1, String value2) {
            addCriterion("workshopname between", value1, value2, "workshopname");
            return (Criteria) this;
        }

        public Criteria andWorkshopnameNotBetween(String value1, String value2) {
            addCriterion("workshopname not between", value1, value2, "workshopname");
            return (Criteria) this;
        }

        public Criteria andStatussIsNull() {
            addCriterion("statuss is null");
            return (Criteria) this;
        }

        public Criteria andStatussIsNotNull() {
            addCriterion("statuss is not null");
            return (Criteria) this;
        }

        public Criteria andStatussEqualTo(String value) {
            addCriterion("statuss =", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotEqualTo(String value) {
            addCriterion("statuss <>", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThan(String value) {
            addCriterion("statuss >", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThanOrEqualTo(String value) {
            addCriterion("statuss >=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThan(String value) {
            addCriterion("statuss <", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThanOrEqualTo(String value) {
            addCriterion("statuss <=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLike(String value) {
            addCriterion("statuss like", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotLike(String value) {
            addCriterion("statuss not like", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussIn(List<String> values) {
            addCriterion("statuss in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotIn(List<String> values) {
            addCriterion("statuss not in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussBetween(String value1, String value2) {
            addCriterion("statuss between", value1, value2, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotBetween(String value1, String value2) {
            addCriterion("statuss not between", value1, value2, "statuss");
            return (Criteria) this;
        }

        public Criteria andAutooIsNull() {
            addCriterion("autoo is null");
            return (Criteria) this;
        }

        public Criteria andAutooIsNotNull() {
            addCriterion("autoo is not null");
            return (Criteria) this;
        }

        public Criteria andAutooEqualTo(String value) {
            addCriterion("autoo =", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooNotEqualTo(String value) {
            addCriterion("autoo <>", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooGreaterThan(String value) {
            addCriterion("autoo >", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooGreaterThanOrEqualTo(String value) {
            addCriterion("autoo >=", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooLessThan(String value) {
            addCriterion("autoo <", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooLessThanOrEqualTo(String value) {
            addCriterion("autoo <=", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooLike(String value) {
            addCriterion("autoo like", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooNotLike(String value) {
            addCriterion("autoo not like", value, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooIn(List<String> values) {
            addCriterion("autoo in", values, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooNotIn(List<String> values) {
            addCriterion("autoo not in", values, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooBetween(String value1, String value2) {
            addCriterion("autoo between", value1, value2, "autoo");
            return (Criteria) this;
        }

        public Criteria andAutooNotBetween(String value1, String value2) {
            addCriterion("autoo not between", value1, value2, "autoo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}