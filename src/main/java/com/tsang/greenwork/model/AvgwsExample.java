package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.List;

public class AvgwsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AvgwsExample() {
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

        public Criteria andAvgTempIsNull() {
            addCriterion("avg_temp is null");
            return (Criteria) this;
        }

        public Criteria andAvgTempIsNotNull() {
            addCriterion("avg_temp is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTempEqualTo(String value) {
            addCriterion("avg_temp =", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempNotEqualTo(String value) {
            addCriterion("avg_temp <>", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempGreaterThan(String value) {
            addCriterion("avg_temp >", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempGreaterThanOrEqualTo(String value) {
            addCriterion("avg_temp >=", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempLessThan(String value) {
            addCriterion("avg_temp <", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempLessThanOrEqualTo(String value) {
            addCriterion("avg_temp <=", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempLike(String value) {
            addCriterion("avg_temp like", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempNotLike(String value) {
            addCriterion("avg_temp not like", value, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempIn(List<String> values) {
            addCriterion("avg_temp in", values, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempNotIn(List<String> values) {
            addCriterion("avg_temp not in", values, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempBetween(String value1, String value2) {
            addCriterion("avg_temp between", value1, value2, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgTempNotBetween(String value1, String value2) {
            addCriterion("avg_temp not between", value1, value2, "avgTemp");
            return (Criteria) this;
        }

        public Criteria andAvgHumIsNull() {
            addCriterion("avg_hum is null");
            return (Criteria) this;
        }

        public Criteria andAvgHumIsNotNull() {
            addCriterion("avg_hum is not null");
            return (Criteria) this;
        }

        public Criteria andAvgHumEqualTo(String value) {
            addCriterion("avg_hum =", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumNotEqualTo(String value) {
            addCriterion("avg_hum <>", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumGreaterThan(String value) {
            addCriterion("avg_hum >", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumGreaterThanOrEqualTo(String value) {
            addCriterion("avg_hum >=", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumLessThan(String value) {
            addCriterion("avg_hum <", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumLessThanOrEqualTo(String value) {
            addCriterion("avg_hum <=", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumLike(String value) {
            addCriterion("avg_hum like", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumNotLike(String value) {
            addCriterion("avg_hum not like", value, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumIn(List<String> values) {
            addCriterion("avg_hum in", values, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumNotIn(List<String> values) {
            addCriterion("avg_hum not in", values, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumBetween(String value1, String value2) {
            addCriterion("avg_hum between", value1, value2, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgHumNotBetween(String value1, String value2) {
            addCriterion("avg_hum not between", value1, value2, "avgHum");
            return (Criteria) this;
        }

        public Criteria andAvgLightIsNull() {
            addCriterion("avg_light is null");
            return (Criteria) this;
        }

        public Criteria andAvgLightIsNotNull() {
            addCriterion("avg_light is not null");
            return (Criteria) this;
        }

        public Criteria andAvgLightEqualTo(String value) {
            addCriterion("avg_light =", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightNotEqualTo(String value) {
            addCriterion("avg_light <>", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightGreaterThan(String value) {
            addCriterion("avg_light >", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightGreaterThanOrEqualTo(String value) {
            addCriterion("avg_light >=", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightLessThan(String value) {
            addCriterion("avg_light <", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightLessThanOrEqualTo(String value) {
            addCriterion("avg_light <=", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightLike(String value) {
            addCriterion("avg_light like", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightNotLike(String value) {
            addCriterion("avg_light not like", value, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightIn(List<String> values) {
            addCriterion("avg_light in", values, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightNotIn(List<String> values) {
            addCriterion("avg_light not in", values, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightBetween(String value1, String value2) {
            addCriterion("avg_light between", value1, value2, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgLightNotBetween(String value1, String value2) {
            addCriterion("avg_light not between", value1, value2, "avgLight");
            return (Criteria) this;
        }

        public Criteria andAvgPm1IsNull() {
            addCriterion("avg_pm1 is null");
            return (Criteria) this;
        }

        public Criteria andAvgPm1IsNotNull() {
            addCriterion("avg_pm1 is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPm1EqualTo(String value) {
            addCriterion("avg_pm1 =", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1NotEqualTo(String value) {
            addCriterion("avg_pm1 <>", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1GreaterThan(String value) {
            addCriterion("avg_pm1 >", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1GreaterThanOrEqualTo(String value) {
            addCriterion("avg_pm1 >=", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1LessThan(String value) {
            addCriterion("avg_pm1 <", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1LessThanOrEqualTo(String value) {
            addCriterion("avg_pm1 <=", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1Like(String value) {
            addCriterion("avg_pm1 like", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1NotLike(String value) {
            addCriterion("avg_pm1 not like", value, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1In(List<String> values) {
            addCriterion("avg_pm1 in", values, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1NotIn(List<String> values) {
            addCriterion("avg_pm1 not in", values, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1Between(String value1, String value2) {
            addCriterion("avg_pm1 between", value1, value2, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm1NotBetween(String value1, String value2) {
            addCriterion("avg_pm1 not between", value1, value2, "avgPm1");
            return (Criteria) this;
        }

        public Criteria andAvgPm25IsNull() {
            addCriterion("avg_pm25 is null");
            return (Criteria) this;
        }

        public Criteria andAvgPm25IsNotNull() {
            addCriterion("avg_pm25 is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPm25EqualTo(String value) {
            addCriterion("avg_pm25 =", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25NotEqualTo(String value) {
            addCriterion("avg_pm25 <>", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25GreaterThan(String value) {
            addCriterion("avg_pm25 >", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25GreaterThanOrEqualTo(String value) {
            addCriterion("avg_pm25 >=", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25LessThan(String value) {
            addCriterion("avg_pm25 <", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25LessThanOrEqualTo(String value) {
            addCriterion("avg_pm25 <=", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25Like(String value) {
            addCriterion("avg_pm25 like", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25NotLike(String value) {
            addCriterion("avg_pm25 not like", value, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25In(List<String> values) {
            addCriterion("avg_pm25 in", values, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25NotIn(List<String> values) {
            addCriterion("avg_pm25 not in", values, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25Between(String value1, String value2) {
            addCriterion("avg_pm25 between", value1, value2, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm25NotBetween(String value1, String value2) {
            addCriterion("avg_pm25 not between", value1, value2, "avgPm25");
            return (Criteria) this;
        }

        public Criteria andAvgPm10IsNull() {
            addCriterion("avg_pm10 is null");
            return (Criteria) this;
        }

        public Criteria andAvgPm10IsNotNull() {
            addCriterion("avg_pm10 is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPm10EqualTo(String value) {
            addCriterion("avg_pm10 =", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10NotEqualTo(String value) {
            addCriterion("avg_pm10 <>", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10GreaterThan(String value) {
            addCriterion("avg_pm10 >", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10GreaterThanOrEqualTo(String value) {
            addCriterion("avg_pm10 >=", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10LessThan(String value) {
            addCriterion("avg_pm10 <", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10LessThanOrEqualTo(String value) {
            addCriterion("avg_pm10 <=", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10Like(String value) {
            addCriterion("avg_pm10 like", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10NotLike(String value) {
            addCriterion("avg_pm10 not like", value, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10In(List<String> values) {
            addCriterion("avg_pm10 in", values, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10NotIn(List<String> values) {
            addCriterion("avg_pm10 not in", values, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10Between(String value1, String value2) {
            addCriterion("avg_pm10 between", value1, value2, "avgPm10");
            return (Criteria) this;
        }

        public Criteria andAvgPm10NotBetween(String value1, String value2) {
            addCriterion("avg_pm10 not between", value1, value2, "avgPm10");
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