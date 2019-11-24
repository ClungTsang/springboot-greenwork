package com.tsang.greenwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MachruntimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachruntimeExample() {
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

        public Criteria andSituationIsNull() {
            addCriterion("situation is null");
            return (Criteria) this;
        }

        public Criteria andSituationIsNotNull() {
            addCriterion("situation is not null");
            return (Criteria) this;
        }

        public Criteria andSituationEqualTo(String value) {
            addCriterion("situation =", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotEqualTo(String value) {
            addCriterion("situation <>", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThan(String value) {
            addCriterion("situation >", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThanOrEqualTo(String value) {
            addCriterion("situation >=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThan(String value) {
            addCriterion("situation <", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThanOrEqualTo(String value) {
            addCriterion("situation <=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLike(String value) {
            addCriterion("situation like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotLike(String value) {
            addCriterion("situation not like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationIn(List<String> values) {
            addCriterion("situation in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotIn(List<String> values) {
            addCriterion("situation not in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationBetween(String value1, String value2) {
            addCriterion("situation between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotBetween(String value1, String value2) {
            addCriterion("situation not between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionIsNull() {
            addCriterion("nrgconsumption is null");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionIsNotNull() {
            addCriterion("nrgconsumption is not null");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionEqualTo(String value) {
            addCriterion("nrgconsumption =", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionNotEqualTo(String value) {
            addCriterion("nrgconsumption <>", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionGreaterThan(String value) {
            addCriterion("nrgconsumption >", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("nrgconsumption >=", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionLessThan(String value) {
            addCriterion("nrgconsumption <", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionLessThanOrEqualTo(String value) {
            addCriterion("nrgconsumption <=", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionLike(String value) {
            addCriterion("nrgconsumption like", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionNotLike(String value) {
            addCriterion("nrgconsumption not like", value, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionIn(List<String> values) {
            addCriterion("nrgconsumption in", values, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionNotIn(List<String> values) {
            addCriterion("nrgconsumption not in", values, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionBetween(String value1, String value2) {
            addCriterion("nrgconsumption between", value1, value2, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andNrgconsumptionNotBetween(String value1, String value2) {
            addCriterion("nrgconsumption not between", value1, value2, "nrgconsumption");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(String value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(String value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(String value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(String value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(String value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLike(String value) {
            addCriterion("frequency like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotLike(String value) {
            addCriterion("frequency not like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<String> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<String> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(String value1, String value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(String value1, String value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
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