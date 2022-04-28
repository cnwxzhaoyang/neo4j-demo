package com.example.accessingdataneo4j.config;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/27 16:38
 */
public class CustomJPAInterceptor extends EmptyInterceptor {

    private final static Pattern pattern = Pattern.compile("[^\\s]+\\s+in\\s*\\(\\s*\\?[^(]*\\)", Pattern.CASE_INSENSITIVE);
    private final static int IN_CAUSE_LIMIT = 1000;


    @Override
    public String onPrepareStatement(String sql) {
//        return sql;
        return super.onPrepareStatement(this.rewriteSqlToAvoidORA_01795(sql));
    }

    private String rewriteSqlToAvoidORA_01795(String sql) {
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()) {
            String inExpression = matcher.group();
            long countOfParameters = inExpression.chars().filter(ch -> ch == '?').count();

            if (countOfParameters <= IN_CAUSE_LIMIT) {
                continue;
            }

            String fieldName = inExpression.substring(0, inExpression.indexOf(' '));
            StringBuilder transformedInExpression = new StringBuilder(" ( ").append(fieldName).append(" in (");

            for (int i = 0; i < countOfParameters; i++) {
                if (i != 0 && i % IN_CAUSE_LIMIT == 0) {
                    transformedInExpression
                            .deleteCharAt(transformedInExpression.length() - 1)
                            .append(") or ").append(fieldName).append(" in (");
                }
                transformedInExpression.append("?,");
            }
            transformedInExpression.deleteCharAt(transformedInExpression.length() - 1).append("))");
            sql = sql.replaceFirst(Pattern.quote(inExpression), transformedInExpression.toString());
        }
        return sql;
    }
}
