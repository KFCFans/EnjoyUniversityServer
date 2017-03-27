package com.eu.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityExample() {
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

        public Criteria andCmidIsNull() {
            addCriterion("cmid is null");
            return (Criteria) this;
        }

        public Criteria andCmidIsNotNull() {
            addCriterion("cmid is not null");
            return (Criteria) this;
        }

        public Criteria andCmidEqualTo(Integer value) {
            addCriterion("cmid =", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotEqualTo(Integer value) {
            addCriterion("cmid <>", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidGreaterThan(Integer value) {
            addCriterion("cmid >", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmid >=", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidLessThan(Integer value) {
            addCriterion("cmid <", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidLessThanOrEqualTo(Integer value) {
            addCriterion("cmid <=", value, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidIn(List<Integer> values) {
            addCriterion("cmid in", values, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotIn(List<Integer> values) {
            addCriterion("cmid not in", values, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidBetween(Integer value1, Integer value2) {
            addCriterion("cmid between", value1, value2, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmidNotBetween(Integer value1, Integer value2) {
            addCriterion("cmid not between", value1, value2, "cmid");
            return (Criteria) this;
        }

        public Criteria andCmLogoIsNull() {
            addCriterion("cm_logo is null");
            return (Criteria) this;
        }

        public Criteria andCmLogoIsNotNull() {
            addCriterion("cm_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCmLogoEqualTo(String value) {
            addCriterion("cm_logo =", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoNotEqualTo(String value) {
            addCriterion("cm_logo <>", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoGreaterThan(String value) {
            addCriterion("cm_logo >", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoGreaterThanOrEqualTo(String value) {
            addCriterion("cm_logo >=", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoLessThan(String value) {
            addCriterion("cm_logo <", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoLessThanOrEqualTo(String value) {
            addCriterion("cm_logo <=", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoLike(String value) {
            addCriterion("cm_logo like", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoNotLike(String value) {
            addCriterion("cm_logo not like", value, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoIn(List<String> values) {
            addCriterion("cm_logo in", values, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoNotIn(List<String> values) {
            addCriterion("cm_logo not in", values, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoBetween(String value1, String value2) {
            addCriterion("cm_logo between", value1, value2, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmLogoNotBetween(String value1, String value2) {
            addCriterion("cm_logo not between", value1, value2, "cmLogo");
            return (Criteria) this;
        }

        public Criteria andCmDetailIsNull() {
            addCriterion("cm_detail is null");
            return (Criteria) this;
        }

        public Criteria andCmDetailIsNotNull() {
            addCriterion("cm_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCmDetailEqualTo(String value) {
            addCriterion("cm_detail =", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailNotEqualTo(String value) {
            addCriterion("cm_detail <>", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailGreaterThan(String value) {
            addCriterion("cm_detail >", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailGreaterThanOrEqualTo(String value) {
            addCriterion("cm_detail >=", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailLessThan(String value) {
            addCriterion("cm_detail <", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailLessThanOrEqualTo(String value) {
            addCriterion("cm_detail <=", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailLike(String value) {
            addCriterion("cm_detail like", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailNotLike(String value) {
            addCriterion("cm_detail not like", value, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailIn(List<String> values) {
            addCriterion("cm_detail in", values, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailNotIn(List<String> values) {
            addCriterion("cm_detail not in", values, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailBetween(String value1, String value2) {
            addCriterion("cm_detail between", value1, value2, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmDetailNotBetween(String value1, String value2) {
            addCriterion("cm_detail not between", value1, value2, "cmDetail");
            return (Criteria) this;
        }

        public Criteria andCmNameIsNull() {
            addCriterion("cm_name is null");
            return (Criteria) this;
        }

        public Criteria andCmNameIsNotNull() {
            addCriterion("cm_name is not null");
            return (Criteria) this;
        }

        public Criteria andCmNameEqualTo(String value) {
            addCriterion("cm_name =", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotEqualTo(String value) {
            addCriterion("cm_name <>", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameGreaterThan(String value) {
            addCriterion("cm_name >", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameGreaterThanOrEqualTo(String value) {
            addCriterion("cm_name >=", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLessThan(String value) {
            addCriterion("cm_name <", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLessThanOrEqualTo(String value) {
            addCriterion("cm_name <=", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameLike(String value) {
            addCriterion("cm_name like", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotLike(String value) {
            addCriterion("cm_name not like", value, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameIn(List<String> values) {
            addCriterion("cm_name in", values, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotIn(List<String> values) {
            addCriterion("cm_name not in", values, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameBetween(String value1, String value2) {
            addCriterion("cm_name between", value1, value2, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmNameNotBetween(String value1, String value2) {
            addCriterion("cm_name not between", value1, value2, "cmName");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundIsNull() {
            addCriterion("cm_background is null");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundIsNotNull() {
            addCriterion("cm_background is not null");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundEqualTo(String value) {
            addCriterion("cm_background =", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundNotEqualTo(String value) {
            addCriterion("cm_background <>", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundGreaterThan(String value) {
            addCriterion("cm_background >", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("cm_background >=", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundLessThan(String value) {
            addCriterion("cm_background <", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundLessThanOrEqualTo(String value) {
            addCriterion("cm_background <=", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundLike(String value) {
            addCriterion("cm_background like", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundNotLike(String value) {
            addCriterion("cm_background not like", value, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundIn(List<String> values) {
            addCriterion("cm_background in", values, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundNotIn(List<String> values) {
            addCriterion("cm_background not in", values, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundBetween(String value1, String value2) {
            addCriterion("cm_background between", value1, value2, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmBackgroundNotBetween(String value1, String value2) {
            addCriterion("cm_background not between", value1, value2, "cmBackground");
            return (Criteria) this;
        }

        public Criteria andCmTypeIsNull() {
            addCriterion("cm_type is null");
            return (Criteria) this;
        }

        public Criteria andCmTypeIsNotNull() {
            addCriterion("cm_type is not null");
            return (Criteria) this;
        }

        public Criteria andCmTypeEqualTo(String value) {
            addCriterion("cm_type =", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotEqualTo(String value) {
            addCriterion("cm_type <>", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeGreaterThan(String value) {
            addCriterion("cm_type >", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cm_type >=", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeLessThan(String value) {
            addCriterion("cm_type <", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeLessThanOrEqualTo(String value) {
            addCriterion("cm_type <=", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeLike(String value) {
            addCriterion("cm_type like", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotLike(String value) {
            addCriterion("cm_type not like", value, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeIn(List<String> values) {
            addCriterion("cm_type in", values, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotIn(List<String> values) {
            addCriterion("cm_type not in", values, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeBetween(String value1, String value2) {
            addCriterion("cm_type between", value1, value2, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmTypeNotBetween(String value1, String value2) {
            addCriterion("cm_type not between", value1, value2, "cmType");
            return (Criteria) this;
        }

        public Criteria andCmAttrIsNull() {
            addCriterion("cm_attr is null");
            return (Criteria) this;
        }

        public Criteria andCmAttrIsNotNull() {
            addCriterion("cm_attr is not null");
            return (Criteria) this;
        }

        public Criteria andCmAttrEqualTo(String value) {
            addCriterion("cm_attr =", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrNotEqualTo(String value) {
            addCriterion("cm_attr <>", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrGreaterThan(String value) {
            addCriterion("cm_attr >", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrGreaterThanOrEqualTo(String value) {
            addCriterion("cm_attr >=", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrLessThan(String value) {
            addCriterion("cm_attr <", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrLessThanOrEqualTo(String value) {
            addCriterion("cm_attr <=", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrLike(String value) {
            addCriterion("cm_attr like", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrNotLike(String value) {
            addCriterion("cm_attr not like", value, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrIn(List<String> values) {
            addCriterion("cm_attr in", values, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrNotIn(List<String> values) {
            addCriterion("cm_attr not in", values, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrBetween(String value1, String value2) {
            addCriterion("cm_attr between", value1, value2, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmAttrNotBetween(String value1, String value2) {
            addCriterion("cm_attr not between", value1, value2, "cmAttr");
            return (Criteria) this;
        }

        public Criteria andCmRecruitIsNull() {
            addCriterion("cm_recruit is null");
            return (Criteria) this;
        }

        public Criteria andCmRecruitIsNotNull() {
            addCriterion("cm_recruit is not null");
            return (Criteria) this;
        }

        public Criteria andCmRecruitEqualTo(Integer value) {
            addCriterion("cm_recruit =", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitNotEqualTo(Integer value) {
            addCriterion("cm_recruit <>", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitGreaterThan(Integer value) {
            addCriterion("cm_recruit >", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_recruit >=", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitLessThan(Integer value) {
            addCriterion("cm_recruit <", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitLessThanOrEqualTo(Integer value) {
            addCriterion("cm_recruit <=", value, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitIn(List<Integer> values) {
            addCriterion("cm_recruit in", values, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitNotIn(List<Integer> values) {
            addCriterion("cm_recruit not in", values, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitBetween(Integer value1, Integer value2) {
            addCriterion("cm_recruit between", value1, value2, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmRecruitNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_recruit not between", value1, value2, "cmRecruit");
            return (Criteria) this;
        }

        public Criteria andCmHeatIsNull() {
            addCriterion("cm_heat is null");
            return (Criteria) this;
        }

        public Criteria andCmHeatIsNotNull() {
            addCriterion("cm_heat is not null");
            return (Criteria) this;
        }

        public Criteria andCmHeatEqualTo(Integer value) {
            addCriterion("cm_heat =", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatNotEqualTo(Integer value) {
            addCriterion("cm_heat <>", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatGreaterThan(Integer value) {
            addCriterion("cm_heat >", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("cm_heat >=", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatLessThan(Integer value) {
            addCriterion("cm_heat <", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatLessThanOrEqualTo(Integer value) {
            addCriterion("cm_heat <=", value, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatIn(List<Integer> values) {
            addCriterion("cm_heat in", values, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatNotIn(List<Integer> values) {
            addCriterion("cm_heat not in", values, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatBetween(Integer value1, Integer value2) {
            addCriterion("cm_heat between", value1, value2, "cmHeat");
            return (Criteria) this;
        }

        public Criteria andCmHeatNotBetween(Integer value1, Integer value2) {
            addCriterion("cm_heat not between", value1, value2, "cmHeat");
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