package com.tsang.greenwork.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MachinforExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachinforExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMachineidIsNull() {
            addCriterion("machineid is null");
            return (Criteria) this;
        }

        public Criteria andMachineidIsNotNull() {
            addCriterion("machineid is not null");
            return (Criteria) this;
        }

        public Criteria andMachineidEqualTo(String value) {
            addCriterion("machineid =", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidNotEqualTo(String value) {
            addCriterion("machineid <>", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidGreaterThan(String value) {
            addCriterion("machineid >", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidGreaterThanOrEqualTo(String value) {
            addCriterion("machineid >=", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidLessThan(String value) {
            addCriterion("machineid <", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidLessThanOrEqualTo(String value) {
            addCriterion("machineid <=", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidLike(String value) {
            addCriterion("machineid like", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidNotLike(String value) {
            addCriterion("machineid not like", value, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidIn(List<String> values) {
            addCriterion("machineid in", values, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidNotIn(List<String> values) {
            addCriterion("machineid not in", values, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidBetween(String value1, String value2) {
            addCriterion("machineid between", value1, value2, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachineidNotBetween(String value1, String value2) {
            addCriterion("machineid not between", value1, value2, "machineid");
            return (Criteria) this;
        }

        public Criteria andMachinemodelIsNull() {
            addCriterion("machinemodel is null");
            return (Criteria) this;
        }

        public Criteria andMachinemodelIsNotNull() {
            addCriterion("machinemodel is not null");
            return (Criteria) this;
        }

        public Criteria andMachinemodelEqualTo(String value) {
            addCriterion("machinemodel =", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelNotEqualTo(String value) {
            addCriterion("machinemodel <>", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelGreaterThan(String value) {
            addCriterion("machinemodel >", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelGreaterThanOrEqualTo(String value) {
            addCriterion("machinemodel >=", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelLessThan(String value) {
            addCriterion("machinemodel <", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelLessThanOrEqualTo(String value) {
            addCriterion("machinemodel <=", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelLike(String value) {
            addCriterion("machinemodel like", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelNotLike(String value) {
            addCriterion("machinemodel not like", value, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelIn(List<String> values) {
            addCriterion("machinemodel in", values, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelNotIn(List<String> values) {
            addCriterion("machinemodel not in", values, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelBetween(String value1, String value2) {
            addCriterion("machinemodel between", value1, value2, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andMachinemodelNotBetween(String value1, String value2) {
            addCriterion("machinemodel not between", value1, value2, "machinemodel");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeIsNull() {
            addCriterion("buyingtime is null");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeIsNotNull() {
            addCriterion("buyingtime is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeEqualTo(Date value) {
            addCriterionForJDBCDate("buyingtime =", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("buyingtime <>", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("buyingtime >", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buyingtime >=", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeLessThan(Date value) {
            addCriterionForJDBCDate("buyingtime <", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buyingtime <=", value, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeIn(List<Date> values) {
            addCriterionForJDBCDate("buyingtime in", values, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("buyingtime not in", values, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buyingtime between", value1, value2, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andBuyingtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buyingtime not between", value1, value2, "buyingtime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeIsNull() {
            addCriterion("productivetime is null");
            return (Criteria) this;
        }

        public Criteria andProductivetimeIsNotNull() {
            addCriterion("productivetime is not null");
            return (Criteria) this;
        }

        public Criteria andProductivetimeEqualTo(Date value) {
            addCriterionForJDBCDate("productivetime =", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("productivetime <>", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("productivetime >", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("productivetime >=", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeLessThan(Date value) {
            addCriterionForJDBCDate("productivetime <", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("productivetime <=", value, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeIn(List<Date> values) {
            addCriterionForJDBCDate("productivetime in", values, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("productivetime not in", values, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("productivetime between", value1, value2, "productivetime");
            return (Criteria) this;
        }

        public Criteria andProductivetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("productivetime not between", value1, value2, "productivetime");
            return (Criteria) this;
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

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
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