package com.eu.pojo;

import java.util.ArrayList;
import java.util.List;

public class ParticipateactivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParticipateactivityExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAvidIsNull() {
            addCriterion("avid is null");
            return (Criteria) this;
        }

        public Criteria andAvidIsNotNull() {
            addCriterion("avid is not null");
            return (Criteria) this;
        }

        public Criteria andAvidEqualTo(Integer value) {
            addCriterion("avid =", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidNotEqualTo(Integer value) {
            addCriterion("avid <>", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidGreaterThan(Integer value) {
            addCriterion("avid >", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("avid >=", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidLessThan(Integer value) {
            addCriterion("avid <", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidLessThanOrEqualTo(Integer value) {
            addCriterion("avid <=", value, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidIn(List<Integer> values) {
            addCriterion("avid in", values, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidNotIn(List<Integer> values) {
            addCriterion("avid not in", values, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidBetween(Integer value1, Integer value2) {
            addCriterion("avid between", value1, value2, "avid");
            return (Criteria) this;
        }

        public Criteria andAvidNotBetween(Integer value1, Integer value2) {
            addCriterion("avid not between", value1, value2, "avid");
            return (Criteria) this;
        }

        public Criteria andVerifystateIsNull() {
            addCriterion("verifystate is null");
            return (Criteria) this;
        }

        public Criteria andVerifystateIsNotNull() {
            addCriterion("verifystate is not null");
            return (Criteria) this;
        }

        public Criteria andVerifystateEqualTo(Integer value) {
            addCriterion("verifystate =", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateNotEqualTo(Integer value) {
            addCriterion("verifystate <>", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateGreaterThan(Integer value) {
            addCriterion("verifystate >", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("verifystate >=", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateLessThan(Integer value) {
            addCriterion("verifystate <", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateLessThanOrEqualTo(Integer value) {
            addCriterion("verifystate <=", value, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateIn(List<Integer> values) {
            addCriterion("verifystate in", values, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateNotIn(List<Integer> values) {
            addCriterion("verifystate not in", values, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateBetween(Integer value1, Integer value2) {
            addCriterion("verifystate between", value1, value2, "verifystate");
            return (Criteria) this;
        }

        public Criteria andVerifystateNotBetween(Integer value1, Integer value2) {
            addCriterion("verifystate not between", value1, value2, "verifystate");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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