package xyz.lemone.apihub.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lemone.apihub.runner.SqlRunner;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private SqlRunner sqlRunner;

    @Autowired
    private DataSource dataSource;

    @GetMapping("test")
    public Object demo() {

        HashMap<String, Object> param = new HashMap<>(1);
        param.put("loginUser.username", "177");
        String configSql =
                "${ " +
                        "if(param('loginUser.username')=='admin'){ " +
                            "return 'select * from users' " +
                        "} else if(3>2) {" +
                            "return 'select * from users2' " +
                        "} else {" +
                            "return 'select * from users where username = :loginUser.username' " +
                        "}" +
                "}";

        String sql = sqlRunner.parseSql(configSql, param);
        System.out.println(sql);
        return sql;


    }


}
