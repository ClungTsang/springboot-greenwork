package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.List;

public class EnvequipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvequipExample() {
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

        public Criteria andWarnIsNull() {
            addCriterion("warn is null");
            return (Criteria) this;
        }

        public Criteria andWarnIsNotNull() {
            addCriterion("warn is not null");
            return (Criteria) this;
        }

        public Criteria andWarnEqualTo(String value) {
            addCriterion("warn =", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnNotEqualTo(String value) {
            addCriterion("warn <>", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnGreaterThan(String value) {
            addCriterion("warn >", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnGreaterThanOrEqualTo(String value) {
            addCriterion("warn >=", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnLessThan(String value) {
            addCriterion("warn <", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnLessThanOrEqualTo(String value) {
            addCriterion("warn <=", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnLike(String value) {
            addCriterion("warn like", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnNotLike(String value) {
            addCriterion("warn not like", value, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnIn(List<String> values) {
            addCriterion("warn in", values, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnNotIn(List<String> values) {
            addCriterion("warn not in", values, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnBetween(String value1, String value2) {
            addCriterion("warn between", value1, value2, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnNotBetween(String value1, String value2) {
            addCriterion("warn not between", value1, value2, "warn");
            return (Criteria) this;
        }

        public Criteria andWarnstatusIsNull() {
            addCriterion("warnstatus is null");
            return (Criteria) this;
        }

        public Criteria andWarnstatusIsNotNull() {
            addCriterion("warnstatus is not null");
            return (Criteria) this;
        }

        public Criteria andWarnstatusEqualTo(String value) {
            addCriterion("warnstatus =", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusNotEqualTo(String value) {
            addCriterion("warnstatus <>", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusGreaterThan(String value) {
            addCriterion("warnstatus >", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusGreaterThanOrEqualTo(String value) {
            addCriterion("warnstatus >=", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusLessThan(String value) {
            addCriterion("warnstatus <", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusLessThanOrEqualTo(String value) {
            addCriterion("warnstatus <=", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusLike(String value) {
            addCriterion("warnstatus like", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusNotLike(String value) {
            addCriterion("warnstatus not like", value, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusIn(List<String> values) {
            addCriterion("warnstatus in", values, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusNotIn(List<String> values) {
            addCriterion("warnstatus not in", values, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusBetween(String value1, String value2) {
            addCriterion("warnstatus between", value1, value2, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andWarnstatusNotBetween(String value1, String value2) {
            addCriterion("warnstatus not between", value1, value2, "warnstatus");
            return (Criteria) this;
        }

        public Criteria andFanIsNull() {
            addCriterion("fan is null");
            return (Criteria) this;
        }

        public Criteria andFanIsNotNull() {
            addCriterion("fan is not null");
            return (Criteria) this;
        }

        public Criteria andFanEqualTo(String value) {
            addCriterion("fan =", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanNotEqualTo(String value) {
            addCriterion("fan <>", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanGreaterThan(String value) {
            addCriterion("fan >", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanGreaterThanOrEqualTo(String value) {
            addCriterion("fan >=", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanLessThan(String value) {
            addCriterion("fan <", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanLessThanOrEqualTo(String value) {
            addCriterion("fan <=", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanLike(String value) {
            addCriterion("fan like", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanNotLike(String value) {
            addCriterion("fan not like", value, "fan");
            return (Criteria) this;
        }

        public Criteria andFanIn(List<String> values) {
            addCriterion("fan in", values, "fan");
            return (Criteria) this;
        }

        public Criteria andFanNotIn(List<String> values) {
            addCriterion("fan not in", values, "fan");
            return (Criteria) this;
        }

        public Criteria andFanBetween(String value1, String value2) {
            addCriterion("fan between", value1, value2, "fan");
            return (Criteria) this;
        }

        public Criteria andFanNotBetween(String value1, String value2) {
            addCriterion("fan not between", value1, value2, "fan");
            return (Criteria) this;
        }

        public Criteria andFanstatusIsNull() {
            addCriterion("fanstatus is null");
            return (Criteria) this;
        }

        public Criteria andFanstatusIsNotNull() {
            addCriterion("fanstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFanstatusEqualTo(String value) {
            addCriterion("fanstatus =", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusNotEqualTo(String value) {
            addCriterion("fanstatus <>", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusGreaterThan(String value) {
            addCriterion("fanstatus >", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusGreaterThanOrEqualTo(String value) {
            addCriterion("fanstatus >=", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusLessThan(String value) {
            addCriterion("fanstatus <", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusLessThanOrEqualTo(String value) {
            addCriterion("fanstatus <=", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusLike(String value) {
            addCriterion("fanstatus like", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusNotLike(String value) {
            addCriterion("fanstatus not like", value, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusIn(List<String> values) {
            addCriterion("fanstatus in", values, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusNotIn(List<String> values) {
            addCriterion("fanstatus not in", values, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusBetween(String value1, String value2) {
            addCriterion("fanstatus between", value1, value2, "fanstatus");
            return (Criteria) this;
        }

        public Criteria andFanstatusNotBetween(String value1, String value2) {
            addCriterion("fanstatus not between", value1, value2, "fanstatus");
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

        public Criteria andLightstatusIsNull() {
            addCriterion("lightstatus is null");
            return (Criteria) this;
        }

        public Criteria andLightstatusIsNotNull() {
            addCriterion("lightstatus is not null");
            return (Criteria) this;
        }

        public Criteria andLightstatusEqualTo(String value) {
            addCriterion("lightstatus =", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusNotEqualTo(String value) {
            addCriterion("lightstatus <>", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusGreaterThan(String value) {
            addCriterion("lightstatus >", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusGreaterThanOrEqualTo(String value) {
            addCriterion("lightstatus >=", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusLessThan(String value) {
            addCriterion("lightstatus <", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusLessThanOrEqualTo(String value) {
            addCriterion("lightstatus <=", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusLike(String value) {
            addCriterion("lightstatus like", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusNotLike(String value) {
            addCriterion("lightstatus not like", value, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusIn(List<String> values) {
            addCriterion("lightstatus in", values, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusNotIn(List<String> values) {
            addCriterion("lightstatus not in", values, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusBetween(String value1, String value2) {
            addCriterion("lightstatus between", value1, value2, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andLightstatusNotBetween(String value1, String value2) {
            addCriterion("lightstatus not between", value1, value2, "lightstatus");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(String value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(String value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(String value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(String value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(String value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(String value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLike(String value) {
            addCriterion("fee like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotLike(String value) {
            addCriterion("fee not like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<String> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<String> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(String value1, String value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(String value1, String value2) {
            addCriterion("fee not between", value1, value2, "fee");
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