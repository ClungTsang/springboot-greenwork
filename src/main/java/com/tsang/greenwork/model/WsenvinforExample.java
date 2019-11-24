package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WsenvinforExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WsenvinforExample() {
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

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNull() {
            addCriterion("humidity is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("humidity is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(String value) {
            addCriterion("humidity =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(String value) {
            addCriterion("humidity <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(String value) {
            addCriterion("humidity >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(String value) {
            addCriterion("humidity >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(String value) {
            addCriterion("humidity <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(String value) {
            addCriterion("humidity <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLike(String value) {
            addCriterion("humidity like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotLike(String value) {
            addCriterion("humidity not like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<String> values) {
            addCriterion("humidity in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<String> values) {
            addCriterion("humidity not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(String value1, String value2) {
            addCriterion("humidity between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(String value1, String value2) {
            addCriterion("humidity not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andLightIsNull() {
            addCriterion("light is null");
            return (Criteria) this;
        }

        public Criteria andLightIsNotNull() {
            addCriterion("light is not null");
            return (Criteria) this;
        }

        public Criteria andLightEqualTo(String value) {
            addCriterion("light =", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotEqualTo(String value) {
            addCriterion("light <>", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightGreaterThan(String value) {
            addCriterion("light >", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightGreaterThanOrEqualTo(String value) {
            addCriterion("light >=", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLessThan(String value) {
            addCriterion("light <", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLessThanOrEqualTo(String value) {
            addCriterion("light <=", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLike(String value) {
            addCriterion("light like", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotLike(String value) {
            addCriterion("light not like", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightIn(List<String> values) {
            addCriterion("light in", values, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotIn(List<String> values) {
            addCriterion("light not in", values, "light");
            return (Criteria) this;
        }

        public Criteria andLightBetween(String value1, String value2) {
            addCriterion("light between", value1, value2, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotBetween(String value1, String value2) {
            addCriterion("light not between", value1, value2, "light");
            return (Criteria) this;
        }

        public Criteria andPm1IsNull() {
            addCriterion("pm1 is null");
            return (Criteria) this;
        }

        public Criteria andPm1IsNotNull() {
            addCriterion("pm1 is not null");
            return (Criteria) this;
        }

        public Criteria andPm1EqualTo(String value) {
            addCriterion("pm1 =", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotEqualTo(String value) {
            addCriterion("pm1 <>", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1GreaterThan(String value) {
            addCriterion("pm1 >", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1GreaterThanOrEqualTo(String value) {
            addCriterion("pm1 >=", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1LessThan(String value) {
            addCriterion("pm1 <", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1LessThanOrEqualTo(String value) {
            addCriterion("pm1 <=", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1Like(String value) {
            addCriterion("pm1 like", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotLike(String value) {
            addCriterion("pm1 not like", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1In(List<String> values) {
            addCriterion("pm1 in", values, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotIn(List<String> values) {
            addCriterion("pm1 not in", values, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1Between(String value1, String value2) {
            addCriterion("pm1 between", value1, value2, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotBetween(String value1, String value2) {
            addCriterion("pm1 not between", value1, value2, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm25IsNull() {
            addCriterion("pm25 is null");
            return (Criteria) this;
        }

        public Criteria andPm25IsNotNull() {
            addCriterion("pm25 is not null");
            return (Criteria) this;
        }

        public Criteria andPm25EqualTo(String value) {
            addCriterion("pm25 =", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotEqualTo(String value) {
            addCriterion("pm25 <>", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThan(String value) {
            addCriterion("pm25 >", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThanOrEqualTo(String value) {
            addCriterion("pm25 >=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThan(String value) {
            addCriterion("pm25 <", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThanOrEqualTo(String value) {
            addCriterion("pm25 <=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Like(String value) {
            addCriterion("pm25 like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotLike(String value) {
            addCriterion("pm25 not like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25In(List<String> values) {
            addCriterion("pm25 in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotIn(List<String> values) {
            addCriterion("pm25 not in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Between(String value1, String value2) {
            addCriterion("pm25 between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotBetween(String value1, String value2) {
            addCriterion("pm25 not between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm10IsNull() {
            addCriterion("pm10 is null");
            return (Criteria) this;
        }

        public Criteria andPm10IsNotNull() {
            addCriterion("pm10 is not null");
            return (Criteria) this;
        }

        public Criteria andPm10EqualTo(String value) {
            addCriterion("pm10 =", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotEqualTo(String value) {
            addCriterion("pm10 <>", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThan(String value) {
            addCriterion("pm10 >", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThanOrEqualTo(String value) {
            addCriterion("pm10 >=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThan(String value) {
            addCriterion("pm10 <", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThanOrEqualTo(String value) {
            addCriterion("pm10 <=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Like(String value) {
            addCriterion("pm10 like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotLike(String value) {
            addCriterion("pm10 not like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10In(List<String> values) {
            addCriterion("pm10 in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotIn(List<String> values) {
            addCriterion("pm10 not in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Between(String value1, String value2) {
            addCriterion("pm10 between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotBetween(String value1, String value2) {
            addCriterion("pm10 not between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andEleIsNull() {
            addCriterion("ele is null");
            return (Criteria) this;
        }

        public Criteria andEleIsNotNull() {
            addCriterion("ele is not null");
            return (Criteria) this;
        }

        public Criteria andEleEqualTo(String value) {
            addCriterion("ele =", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleNotEqualTo(String value) {
            addCriterion("ele <>", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleGreaterThan(String value) {
            addCriterion("ele >", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleGreaterThanOrEqualTo(String value) {
            addCriterion("ele >=", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleLessThan(String value) {
            addCriterion("ele <", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleLessThanOrEqualTo(String value) {
            addCriterion("ele <=", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleLike(String value) {
            addCriterion("ele like", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleNotLike(String value) {
            addCriterion("ele not like", value, "ele");
            return (Criteria) this;
        }

        public Criteria andEleIn(List<String> values) {
            addCriterion("ele in", values, "ele");
            return (Criteria) this;
        }

        public Criteria andEleNotIn(List<String> values) {
            addCriterion("ele not in", values, "ele");
            return (Criteria) this;
        }

        public Criteria andEleBetween(String value1, String value2) {
            addCriterion("ele between", value1, value2, "ele");
            return (Criteria) this;
        }

        public Criteria andEleNotBetween(String value1, String value2) {
            addCriterion("ele not between", value1, value2, "ele");
            return (Criteria) this;
        }

        public Criteria andSignallIsNull() {
            addCriterion("signall is null");
            return (Criteria) this;
        }

        public Criteria andSignallIsNotNull() {
            addCriterion("signall is not null");
            return (Criteria) this;
        }

        public Criteria andSignallEqualTo(String value) {
            addCriterion("signall =", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallNotEqualTo(String value) {
            addCriterion("signall <>", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallGreaterThan(String value) {
            addCriterion("signall >", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallGreaterThanOrEqualTo(String value) {
            addCriterion("signall >=", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallLessThan(String value) {
            addCriterion("signall <", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallLessThanOrEqualTo(String value) {
            addCriterion("signall <=", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallLike(String value) {
            addCriterion("signall like", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallNotLike(String value) {
            addCriterion("signall not like", value, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallIn(List<String> values) {
            addCriterion("signall in", values, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallNotIn(List<String> values) {
            addCriterion("signall not in", values, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallBetween(String value1, String value2) {
            addCriterion("signall between", value1, value2, "signall");
            return (Criteria) this;
        }

        public Criteria andSignallNotBetween(String value1, String value2) {
            addCriterion("signall not between", value1, value2, "signall");
            return (Criteria) this;
        }

        public Criteria andFreIsNull() {
            addCriterion("fre is null");
            return (Criteria) this;
        }

        public Criteria andFreIsNotNull() {
            addCriterion("fre is not null");
            return (Criteria) this;
        }

        public Criteria andFreEqualTo(String value) {
            addCriterion("fre =", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreNotEqualTo(String value) {
            addCriterion("fre <>", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreGreaterThan(String value) {
            addCriterion("fre >", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreGreaterThanOrEqualTo(String value) {
            addCriterion("fre >=", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreLessThan(String value) {
            addCriterion("fre <", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreLessThanOrEqualTo(String value) {
            addCriterion("fre <=", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreLike(String value) {
            addCriterion("fre like", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreNotLike(String value) {
            addCriterion("fre not like", value, "fre");
            return (Criteria) this;
        }

        public Criteria andFreIn(List<String> values) {
            addCriterion("fre in", values, "fre");
            return (Criteria) this;
        }

        public Criteria andFreNotIn(List<String> values) {
            addCriterion("fre not in", values, "fre");
            return (Criteria) this;
        }

        public Criteria andFreBetween(String value1, String value2) {
            addCriterion("fre between", value1, value2, "fre");
            return (Criteria) this;
        }

        public Criteria andFreNotBetween(String value1, String value2) {
            addCriterion("fre not between", value1, value2, "fre");
            return (Criteria) this;
        }

        public Criteria andNrgIsNull() {
            addCriterion("nrg is null");
            return (Criteria) this;
        }

        public Criteria andNrgIsNotNull() {
            addCriterion("nrg is not null");
            return (Criteria) this;
        }

        public Criteria andNrgEqualTo(String value) {
            addCriterion("nrg =", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgNotEqualTo(String value) {
            addCriterion("nrg <>", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgGreaterThan(String value) {
            addCriterion("nrg >", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgGreaterThanOrEqualTo(String value) {
            addCriterion("nrg >=", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgLessThan(String value) {
            addCriterion("nrg <", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgLessThanOrEqualTo(String value) {
            addCriterion("nrg <=", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgLike(String value) {
            addCriterion("nrg like", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgNotLike(String value) {
            addCriterion("nrg not like", value, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgIn(List<String> values) {
            addCriterion("nrg in", values, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgNotIn(List<String> values) {
            addCriterion("nrg not in", values, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgBetween(String value1, String value2) {
            addCriterion("nrg between", value1, value2, "nrg");
            return (Criteria) this;
        }

        public Criteria andNrgNotBetween(String value1, String value2) {
            addCriterion("nrg not between", value1, value2, "nrg");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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