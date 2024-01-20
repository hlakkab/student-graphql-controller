package com.example.controller;

import graphql.GraphQL;
import graphql.execution.instrumentation.NoOpInstrumentation;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
package com.ochibooh.teacher_student_crud.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User getUserByEmail(String email) {

        return userService.getUserByEmail(email);
    }

    public Course registerCourse(Long userId, String courseName) {

        return userService.registerCourse(userId, courseName);
    }

    public String changeCourseStatus(Long courseId, String action) {
            return userService.changeCourseStatus(courseId, action);
    }
}
