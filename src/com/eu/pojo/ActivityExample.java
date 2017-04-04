package com.eu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andAvTitleIsNull() {
            addCriterion("av_title is null");
            return (Criteria) this;
        }

        public Criteria andAvTitleIsNotNull() {
            addCriterion("av_title is not null");
            return (Criteria) this;
        }

        public Criteria andAvTitleEqualTo(String value) {
            addCriterion("av_title =", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleNotEqualTo(String value) {
            addCriterion("av_title <>", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleGreaterThan(String value) {
            addCriterion("av_title >", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleGreaterThanOrEqualTo(String value) {
            addCriterion("av_title >=", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleLessThan(String value) {
            addCriterion("av_title <", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleLessThanOrEqualTo(String value) {
            addCriterion("av_title <=", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleLike(String value) {
            addCriterion("av_title like", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleNotLike(String value) {
            addCriterion("av_title not like", value, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleIn(List<String> values) {
            addCriterion("av_title in", values, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleNotIn(List<String> values) {
            addCriterion("av_title not in", values, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleBetween(String value1, String value2) {
            addCriterion("av_title between", value1, value2, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvTitleNotBetween(String value1, String value2) {
            addCriterion("av_title not between", value1, value2, "avTitle");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeIsNull() {
            addCriterion("av_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeIsNotNull() {
            addCriterion("av_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeEqualTo(Date value) {
            addCriterion("av_starttime =", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeNotEqualTo(Date value) {
            addCriterion("av_starttime <>", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeGreaterThan(Date value) {
            addCriterion("av_starttime >", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("av_starttime >=", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeLessThan(Date value) {
            addCriterion("av_starttime <", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("av_starttime <=", value, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeIn(List<Date> values) {
            addCriterion("av_starttime in", values, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeNotIn(List<Date> values) {
            addCriterion("av_starttime not in", values, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeBetween(Date value1, Date value2) {
            addCriterion("av_starttime between", value1, value2, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("av_starttime not between", value1, value2, "avStarttime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeIsNull() {
            addCriterion("av_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeIsNotNull() {
            addCriterion("av_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeEqualTo(Date value) {
            addCriterion("av_endtime =", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeNotEqualTo(Date value) {
            addCriterion("av_endtime <>", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeGreaterThan(Date value) {
            addCriterion("av_endtime >", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("av_endtime >=", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeLessThan(Date value) {
            addCriterion("av_endtime <", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("av_endtime <=", value, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeIn(List<Date> values) {
            addCriterion("av_endtime in", values, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeNotIn(List<Date> values) {
            addCriterion("av_endtime not in", values, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeBetween(Date value1, Date value2) {
            addCriterion("av_endtime between", value1, value2, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("av_endtime not between", value1, value2, "avEndtime");
            return (Criteria) this;
        }

        public Criteria andAvPriceIsNull() {
            addCriterion("av_price is null");
            return (Criteria) this;
        }

        public Criteria andAvPriceIsNotNull() {
            addCriterion("av_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvPriceEqualTo(Float value) {
            addCriterion("av_price =", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceNotEqualTo(Float value) {
            addCriterion("av_price <>", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceGreaterThan(Float value) {
            addCriterion("av_price >", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("av_price >=", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceLessThan(Float value) {
            addCriterion("av_price <", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceLessThanOrEqualTo(Float value) {
            addCriterion("av_price <=", value, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceIn(List<Float> values) {
            addCriterion("av_price in", values, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceNotIn(List<Float> values) {
            addCriterion("av_price not in", values, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceBetween(Float value1, Float value2) {
            addCriterion("av_price between", value1, value2, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvPriceNotBetween(Float value1, Float value2) {
            addCriterion("av_price not between", value1, value2, "avPrice");
            return (Criteria) this;
        }

        public Criteria andAvDetailIsNull() {
            addCriterion("av_detail is null");
            return (Criteria) this;
        }

        public Criteria andAvDetailIsNotNull() {
            addCriterion("av_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAvDetailEqualTo(String value) {
            addCriterion("av_detail =", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailNotEqualTo(String value) {
            addCriterion("av_detail <>", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailGreaterThan(String value) {
            addCriterion("av_detail >", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailGreaterThanOrEqualTo(String value) {
            addCriterion("av_detail >=", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailLessThan(String value) {
            addCriterion("av_detail <", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailLessThanOrEqualTo(String value) {
            addCriterion("av_detail <=", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailLike(String value) {
            addCriterion("av_detail like", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailNotLike(String value) {
            addCriterion("av_detail not like", value, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailIn(List<String> values) {
            addCriterion("av_detail in", values, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailNotIn(List<String> values) {
            addCriterion("av_detail not in", values, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailBetween(String value1, String value2) {
            addCriterion("av_detail between", value1, value2, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvDetailNotBetween(String value1, String value2) {
            addCriterion("av_detail not between", value1, value2, "avDetail");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumIsNull() {
            addCriterion("av_expectnum is null");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumIsNotNull() {
            addCriterion("av_expectnum is not null");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumEqualTo(Integer value) {
            addCriterion("av_expectnum =", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumNotEqualTo(Integer value) {
            addCriterion("av_expectnum <>", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumGreaterThan(Integer value) {
            addCriterion("av_expectnum >", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_expectnum >=", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumLessThan(Integer value) {
            addCriterion("av_expectnum <", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumLessThanOrEqualTo(Integer value) {
            addCriterion("av_expectnum <=", value, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumIn(List<Integer> values) {
            addCriterion("av_expectnum in", values, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumNotIn(List<Integer> values) {
            addCriterion("av_expectnum not in", values, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumBetween(Integer value1, Integer value2) {
            addCriterion("av_expectnum between", value1, value2, "avExpectnum");
            return (Criteria) this;
        }

        public Criteria andAvExpectnumNotBetween(Integer value1, Integer value2) {
            addCriterion("av_expectnum not between", value1, value2, "avExpectnum");
            return (Criteria) this;
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

        public Criteria andAvLogoIsNull() {
            addCriterion("av_logo is null");
            return (Criteria) this;
        }

        public Criteria andAvLogoIsNotNull() {
            addCriterion("av_logo is not null");
            return (Criteria) this;
        }

        public Criteria andAvLogoEqualTo(String value) {
            addCriterion("av_logo =", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoNotEqualTo(String value) {
            addCriterion("av_logo <>", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoGreaterThan(String value) {
            addCriterion("av_logo >", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoGreaterThanOrEqualTo(String value) {
            addCriterion("av_logo >=", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoLessThan(String value) {
            addCriterion("av_logo <", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoLessThanOrEqualTo(String value) {
            addCriterion("av_logo <=", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoLike(String value) {
            addCriterion("av_logo like", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoNotLike(String value) {
            addCriterion("av_logo not like", value, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoIn(List<String> values) {
            addCriterion("av_logo in", values, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoNotIn(List<String> values) {
            addCriterion("av_logo not in", values, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoBetween(String value1, String value2) {
            addCriterion("av_logo between", value1, value2, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvLogoNotBetween(String value1, String value2) {
            addCriterion("av_logo not between", value1, value2, "avLogo");
            return (Criteria) this;
        }

        public Criteria andAvStateIsNull() {
            addCriterion("av_state is null");
            return (Criteria) this;
        }

        public Criteria andAvStateIsNotNull() {
            addCriterion("av_state is not null");
            return (Criteria) this;
        }

        public Criteria andAvStateEqualTo(Integer value) {
            addCriterion("av_state =", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateNotEqualTo(Integer value) {
            addCriterion("av_state <>", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateGreaterThan(Integer value) {
            addCriterion("av_state >", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_state >=", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateLessThan(Integer value) {
            addCriterion("av_state <", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateLessThanOrEqualTo(Integer value) {
            addCriterion("av_state <=", value, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateIn(List<Integer> values) {
            addCriterion("av_state in", values, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateNotIn(List<Integer> values) {
            addCriterion("av_state not in", values, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateBetween(Integer value1, Integer value2) {
            addCriterion("av_state between", value1, value2, "avState");
            return (Criteria) this;
        }

        public Criteria andAvStateNotBetween(Integer value1, Integer value2) {
            addCriterion("av_state not between", value1, value2, "avState");
            return (Criteria) this;
        }

        public Criteria andAvRegisterIsNull() {
            addCriterion("av_register is null");
            return (Criteria) this;
        }

        public Criteria andAvRegisterIsNotNull() {
            addCriterion("av_register is not null");
            return (Criteria) this;
        }

        public Criteria andAvRegisterEqualTo(Integer value) {
            addCriterion("av_register =", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterNotEqualTo(Integer value) {
            addCriterion("av_register <>", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterGreaterThan(Integer value) {
            addCriterion("av_register >", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterGreaterThanOrEqualTo(Integer value) {
            addCriterion("av_register >=", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterLessThan(Integer value) {
            addCriterion("av_register <", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterLessThanOrEqualTo(Integer value) {
            addCriterion("av_register <=", value, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterIn(List<Integer> values) {
            addCriterion("av_register in", values, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterNotIn(List<Integer> values) {
            addCriterion("av_register not in", values, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterBetween(Integer value1, Integer value2) {
            addCriterion("av_register between", value1, value2, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvRegisterNotBetween(Integer value1, Integer value2) {
            addCriterion("av_register not between", value1, value2, "avRegister");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineIsNull() {
            addCriterion("av_enrolldeadline is null");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineIsNotNull() {
            addCriterion("av_enrolldeadline is not null");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineEqualTo(Date value) {
            addCriterion("av_enrolldeadline =", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineNotEqualTo(Date value) {
            addCriterion("av_enrolldeadline <>", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineGreaterThan(Date value) {
            addCriterion("av_enrolldeadline >", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("av_enrolldeadline >=", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineLessThan(Date value) {
            addCriterion("av_enrolldeadline <", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineLessThanOrEqualTo(Date value) {
            addCriterion("av_enrolldeadline <=", value, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineIn(List<Date> values) {
            addCriterion("av_enrolldeadline in", values, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineNotIn(List<Date> values) {
            addCriterion("av_enrolldeadline not in", values, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineBetween(Date value1, Date value2) {
            addCriterion("av_enrolldeadline between", value1, value2, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvEnrolldeadlineNotBetween(Date value1, Date value2) {
            addCriterion("av_enrolldeadline not between", value1, value2, "avEnrolldeadline");
            return (Criteria) this;
        }

        public Criteria andAvPlaceIsNull() {
            addCriterion("av_place is null");
            return (Criteria) this;
        }

        public Criteria andAvPlaceIsNotNull() {
            addCriterion("av_place is not null");
            return (Criteria) this;
        }

        public Criteria andAvPlaceEqualTo(String value) {
            addCriterion("av_place =", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceNotEqualTo(String value) {
            addCriterion("av_place <>", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceGreaterThan(String value) {
            addCriterion("av_place >", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("av_place >=", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceLessThan(String value) {
            addCriterion("av_place <", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceLessThanOrEqualTo(String value) {
            addCriterion("av_place <=", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceLike(String value) {
            addCriterion("av_place like", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceNotLike(String value) {
            addCriterion("av_place not like", value, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceIn(List<String> values) {
            addCriterion("av_place in", values, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceNotIn(List<String> values) {
            addCriterion("av_place not in", values, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceBetween(String value1, String value2) {
            addCriterion("av_place between", value1, value2, "avPlace");
            return (Criteria) this;
        }

        public Criteria andAvPlaceNotBetween(String value1, String value2) {
            addCriterion("av_place not between", value1, value2, "avPlace");
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