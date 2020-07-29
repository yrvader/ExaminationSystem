package vip.yydz.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestExample() {
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

        public Criteria andTestidIsNull() {
            addCriterion("testid is null");
            return (Criteria) this;
        }

        public Criteria andTestidIsNotNull() {
            addCriterion("testid is not null");
            return (Criteria) this;
        }

        public Criteria andTestidEqualTo(Integer value) {
            addCriterion("testid =", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotEqualTo(Integer value) {
            addCriterion("testid <>", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThan(Integer value) {
            addCriterion("testid >", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("testid >=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThan(Integer value) {
            addCriterion("testid <", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThanOrEqualTo(Integer value) {
            addCriterion("testid <=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidIn(List<Integer> values) {
            addCriterion("testid in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotIn(List<Integer> values) {
            addCriterion("testid not in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidBetween(Integer value1, Integer value2) {
            addCriterion("testid between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotBetween(Integer value1, Integer value2) {
            addCriterion("testid not between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterionForJDBCDate("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterionForJDBCDate("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterionForJDBCDate("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterionForJDBCDate("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate not between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andEdateIsNull() {
            addCriterion("edate is null");
            return (Criteria) this;
        }

        public Criteria andEdateIsNotNull() {
            addCriterion("edate is not null");
            return (Criteria) this;
        }

        public Criteria andEdateEqualTo(Date value) {
            addCriterionForJDBCDate("edate =", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("edate <>", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThan(Date value) {
            addCriterionForJDBCDate("edate >", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("edate >=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThan(Date value) {
            addCriterionForJDBCDate("edate <", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("edate <=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateIn(List<Date> values) {
            addCriterionForJDBCDate("edate in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("edate not in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("edate between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("edate not between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andIsubmitIsNull() {
            addCriterion("isubmit is null");
            return (Criteria) this;
        }

        public Criteria andIsubmitIsNotNull() {
            addCriterion("isubmit is not null");
            return (Criteria) this;
        }

        public Criteria andIsubmitEqualTo(Boolean value) {
            addCriterion("isubmit =", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitNotEqualTo(Boolean value) {
            addCriterion("isubmit <>", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitGreaterThan(Boolean value) {
            addCriterion("isubmit >", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isubmit >=", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitLessThan(Boolean value) {
            addCriterion("isubmit <", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitLessThanOrEqualTo(Boolean value) {
            addCriterion("isubmit <=", value, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitIn(List<Boolean> values) {
            addCriterion("isubmit in", values, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitNotIn(List<Boolean> values) {
            addCriterion("isubmit not in", values, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitBetween(Boolean value1, Boolean value2) {
            addCriterion("isubmit between", value1, value2, "isubmit");
            return (Criteria) this;
        }

        public Criteria andIsubmitNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isubmit not between", value1, value2, "isubmit");
            return (Criteria) this;
        }

        public Criteria andPnumberIsNull() {
            addCriterion("pnumber is null");
            return (Criteria) this;
        }

        public Criteria andPnumberIsNotNull() {
            addCriterion("pnumber is not null");
            return (Criteria) this;
        }

        public Criteria andPnumberEqualTo(Integer value) {
            addCriterion("pnumber =", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberNotEqualTo(Integer value) {
            addCriterion("pnumber <>", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberGreaterThan(Integer value) {
            addCriterion("pnumber >", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pnumber >=", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberLessThan(Integer value) {
            addCriterion("pnumber <", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberLessThanOrEqualTo(Integer value) {
            addCriterion("pnumber <=", value, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberIn(List<Integer> values) {
            addCriterion("pnumber in", values, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberNotIn(List<Integer> values) {
            addCriterion("pnumber not in", values, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberBetween(Integer value1, Integer value2) {
            addCriterion("pnumber between", value1, value2, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pnumber not between", value1, value2, "pnumber");
            return (Criteria) this;
        }

        public Criteria andPicturepathsIsNull() {
            addCriterion("picturepaths is null");
            return (Criteria) this;
        }

        public Criteria andPicturepathsIsNotNull() {
            addCriterion("picturepaths is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepathsEqualTo(String value) {
            addCriterion("picturepaths =", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsNotEqualTo(String value) {
            addCriterion("picturepaths <>", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsGreaterThan(String value) {
            addCriterion("picturepaths >", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsGreaterThanOrEqualTo(String value) {
            addCriterion("picturepaths >=", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsLessThan(String value) {
            addCriterion("picturepaths <", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsLessThanOrEqualTo(String value) {
            addCriterion("picturepaths <=", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsLike(String value) {
            addCriterion("picturepaths like", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsNotLike(String value) {
            addCriterion("picturepaths not like", value, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsIn(List<String> values) {
            addCriterion("picturepaths in", values, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsNotIn(List<String> values) {
            addCriterion("picturepaths not in", values, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsBetween(String value1, String value2) {
            addCriterion("picturepaths between", value1, value2, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andPicturepathsNotBetween(String value1, String value2) {
            addCriterion("picturepaths not between", value1, value2, "picturepaths");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNull() {
            addCriterion("snumber is null");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNotNull() {
            addCriterion("snumber is not null");
            return (Criteria) this;
        }

        public Criteria andSnumberEqualTo(Integer value) {
            addCriterion("snumber =", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotEqualTo(Integer value) {
            addCriterion("snumber <>", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThan(Integer value) {
            addCriterion("snumber >", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("snumber >=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThan(Integer value) {
            addCriterion("snumber <", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThanOrEqualTo(Integer value) {
            addCriterion("snumber <=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberIn(List<Integer> values) {
            addCriterion("snumber in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotIn(List<Integer> values) {
            addCriterion("snumber not in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberBetween(Integer value1, Integer value2) {
            addCriterion("snumber between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("snumber not between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andScoresIsNull() {
            addCriterion("scores is null");
            return (Criteria) this;
        }

        public Criteria andScoresIsNotNull() {
            addCriterion("scores is not null");
            return (Criteria) this;
        }

        public Criteria andScoresEqualTo(String value) {
            addCriterion("scores =", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresNotEqualTo(String value) {
            addCriterion("scores <>", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresGreaterThan(String value) {
            addCriterion("scores >", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresGreaterThanOrEqualTo(String value) {
            addCriterion("scores >=", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresLessThan(String value) {
            addCriterion("scores <", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresLessThanOrEqualTo(String value) {
            addCriterion("scores <=", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresLike(String value) {
            addCriterion("scores like", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresNotLike(String value) {
            addCriterion("scores not like", value, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresIn(List<String> values) {
            addCriterion("scores in", values, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresNotIn(List<String> values) {
            addCriterion("scores not in", values, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresBetween(String value1, String value2) {
            addCriterion("scores between", value1, value2, "scores");
            return (Criteria) this;
        }

        public Criteria andScoresNotBetween(String value1, String value2) {
            addCriterion("scores not between", value1, value2, "scores");
            return (Criteria) this;
        }

        public Criteria andIdreadIsNull() {
            addCriterion("idread is null");
            return (Criteria) this;
        }

        public Criteria andIdreadIsNotNull() {
            addCriterion("idread is not null");
            return (Criteria) this;
        }

        public Criteria andIdreadEqualTo(Boolean value) {
            addCriterion("idread =", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadNotEqualTo(Boolean value) {
            addCriterion("idread <>", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadGreaterThan(Boolean value) {
            addCriterion("idread >", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("idread >=", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadLessThan(Boolean value) {
            addCriterion("idread <", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadLessThanOrEqualTo(Boolean value) {
            addCriterion("idread <=", value, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadIn(List<Boolean> values) {
            addCriterion("idread in", values, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadNotIn(List<Boolean> values) {
            addCriterion("idread not in", values, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadBetween(Boolean value1, Boolean value2) {
            addCriterion("idread between", value1, value2, "idread");
            return (Criteria) this;
        }

        public Criteria andIdreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("idread not between", value1, value2, "idread");
            return (Criteria) this;
        }

        public Criteria andTestfkIsNull() {
            addCriterion("testfk is null");
            return (Criteria) this;
        }

        public Criteria andTestfkIsNotNull() {
            addCriterion("testfk is not null");
            return (Criteria) this;
        }

        public Criteria andTestfkEqualTo(Integer value) {
            addCriterion("testfk =", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkNotEqualTo(Integer value) {
            addCriterion("testfk <>", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkGreaterThan(Integer value) {
            addCriterion("testfk >", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkGreaterThanOrEqualTo(Integer value) {
            addCriterion("testfk >=", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkLessThan(Integer value) {
            addCriterion("testfk <", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkLessThanOrEqualTo(Integer value) {
            addCriterion("testfk <=", value, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkIn(List<Integer> values) {
            addCriterion("testfk in", values, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkNotIn(List<Integer> values) {
            addCriterion("testfk not in", values, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkBetween(Integer value1, Integer value2) {
            addCriterion("testfk between", value1, value2, "testfk");
            return (Criteria) this;
        }

        public Criteria andTestfkNotBetween(Integer value1, Integer value2) {
            addCriterion("testfk not between", value1, value2, "testfk");
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