package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.List;

public class AvgmachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AvgmachExample() {
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

        public Criteria andYear1IsNull() {
            addCriterion("year1 is null");
            return (Criteria) this;
        }

        public Criteria andYear1IsNotNull() {
            addCriterion("year1 is not null");
            return (Criteria) this;
        }

        public Criteria andYear1EqualTo(String value) {
            addCriterion("year1 =", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1NotEqualTo(String value) {
            addCriterion("year1 <>", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1GreaterThan(String value) {
            addCriterion("year1 >", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1GreaterThanOrEqualTo(String value) {
            addCriterion("year1 >=", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1LessThan(String value) {
            addCriterion("year1 <", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1LessThanOrEqualTo(String value) {
            addCriterion("year1 <=", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1Like(String value) {
            addCriterion("year1 like", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1NotLike(String value) {
            addCriterion("year1 not like", value, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1In(List<String> values) {
            addCriterion("year1 in", values, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1NotIn(List<String> values) {
            addCriterion("year1 not in", values, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1Between(String value1, String value2) {
            addCriterion("year1 between", value1, value2, "year1");
            return (Criteria) this;
        }

        public Criteria andYear1NotBetween(String value1, String value2) {
            addCriterion("year1 not between", value1, value2, "year1");
            return (Criteria) this;
        }

        public Criteria andMonth1IsNull() {
            addCriterion("month1 is null");
            return (Criteria) this;
        }

        public Criteria andMonth1IsNotNull() {
            addCriterion("month1 is not null");
            return (Criteria) this;
        }

        public Criteria andMonth1EqualTo(String value) {
            addCriterion("month1 =", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1NotEqualTo(String value) {
            addCriterion("month1 <>", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1GreaterThan(String value) {
            addCriterion("month1 >", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1GreaterThanOrEqualTo(String value) {
            addCriterion("month1 >=", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1LessThan(String value) {
            addCriterion("month1 <", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1LessThanOrEqualTo(String value) {
            addCriterion("month1 <=", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1Like(String value) {
            addCriterion("month1 like", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1NotLike(String value) {
            addCriterion("month1 not like", value, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1In(List<String> values) {
            addCriterion("month1 in", values, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1NotIn(List<String> values) {
            addCriterion("month1 not in", values, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1Between(String value1, String value2) {
            addCriterion("month1 between", value1, value2, "month1");
            return (Criteria) this;
        }

        public Criteria andMonth1NotBetween(String value1, String value2) {
            addCriterion("month1 not between", value1, value2, "month1");
            return (Criteria) this;
        }

        public Criteria andDay1IsNull() {
            addCriterion("day1 is null");
            return (Criteria) this;
        }

        public Criteria andDay1IsNotNull() {
            addCriterion("day1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay1EqualTo(String value) {
            addCriterion("day1 =", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1NotEqualTo(String value) {
            addCriterion("day1 <>", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1GreaterThan(String value) {
            addCriterion("day1 >", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1GreaterThanOrEqualTo(String value) {
            addCriterion("day1 >=", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1LessThan(String value) {
            addCriterion("day1 <", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1LessThanOrEqualTo(String value) {
            addCriterion("day1 <=", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1Like(String value) {
            addCriterion("day1 like", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1NotLike(String value) {
            addCriterion("day1 not like", value, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1In(List<String> values) {
            addCriterion("day1 in", values, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1NotIn(List<String> values) {
            addCriterion("day1 not in", values, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1Between(String value1, String value2) {
            addCriterion("day1 between", value1, value2, "day1");
            return (Criteria) this;
        }

        public Criteria andDay1NotBetween(String value1, String value2) {
            addCriterion("day1 not between", value1, value2, "day1");
            return (Criteria) this;
        }

        public Criteria andHour1IsNull() {
            addCriterion("hour1 is null");
            return (Criteria) this;
        }

        public Criteria andHour1IsNotNull() {
            addCriterion("hour1 is not null");
            return (Criteria) this;
        }

        public Criteria andHour1EqualTo(String value) {
            addCriterion("hour1 =", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotEqualTo(String value) {
            addCriterion("hour1 <>", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThan(String value) {
            addCriterion("hour1 >", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThanOrEqualTo(String value) {
            addCriterion("hour1 >=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThan(String value) {
            addCriterion("hour1 <", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThanOrEqualTo(String value) {
            addCriterion("hour1 <=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1Like(String value) {
            addCriterion("hour1 like", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotLike(String value) {
            addCriterion("hour1 not like", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1In(List<String> values) {
            addCriterion("hour1 in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotIn(List<String> values) {
            addCriterion("hour1 not in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1Between(String value1, String value2) {
            addCriterion("hour1 between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotBetween(String value1, String value2) {
            addCriterion("hour1 not between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andAvgnrgIsNull() {
            addCriterion("avgnrg is null");
            return (Criteria) this;
        }

        public Criteria andAvgnrgIsNotNull() {
            addCriterion("avgnrg is not null");
            return (Criteria) this;
        }

        public Criteria andAvgnrgEqualTo(String value) {
            addCriterion("avgnrg =", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgNotEqualTo(String value) {
            addCriterion("avgnrg <>", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgGreaterThan(String value) {
            addCriterion("avgnrg >", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgGreaterThanOrEqualTo(String value) {
            addCriterion("avgnrg >=", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgLessThan(String value) {
            addCriterion("avgnrg <", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgLessThanOrEqualTo(String value) {
            addCriterion("avgnrg <=", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgLike(String value) {
            addCriterion("avgnrg like", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgNotLike(String value) {
            addCriterion("avgnrg not like", value, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgIn(List<String> values) {
            addCriterion("avgnrg in", values, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgNotIn(List<String> values) {
            addCriterion("avgnrg not in", values, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgBetween(String value1, String value2) {
            addCriterion("avgnrg between", value1, value2, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgnrgNotBetween(String value1, String value2) {
            addCriterion("avgnrg not between", value1, value2, "avgnrg");
            return (Criteria) this;
        }

        public Criteria andAvgfreIsNull() {
            addCriterion("avgfre is null");
            return (Criteria) this;
        }

        public Criteria andAvgfreIsNotNull() {
            addCriterion("avgfre is not null");
            return (Criteria) this;
        }

        public Criteria andAvgfreEqualTo(String value) {
            addCriterion("avgfre =", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreNotEqualTo(String value) {
            addCriterion("avgfre <>", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreGreaterThan(String value) {
            addCriterion("avgfre >", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreGreaterThanOrEqualTo(String value) {
            addCriterion("avgfre >=", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreLessThan(String value) {
            addCriterion("avgfre <", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreLessThanOrEqualTo(String value) {
            addCriterion("avgfre <=", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreLike(String value) {
            addCriterion("avgfre like", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreNotLike(String value) {
            addCriterion("avgfre not like", value, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreIn(List<String> values) {
            addCriterion("avgfre in", values, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreNotIn(List<String> values) {
            addCriterion("avgfre not in", values, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreBetween(String value1, String value2) {
            addCriterion("avgfre between", value1, value2, "avgfre");
            return (Criteria) this;
        }

        public Criteria andAvgfreNotBetween(String value1, String value2) {
            addCriterion("avgfre not between", value1, value2, "avgfre");
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