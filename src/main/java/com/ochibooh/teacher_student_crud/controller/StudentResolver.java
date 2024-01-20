package com.ochibooh.teacher_student_crud.controller;

import com.ochibooh.teacher_student_crud.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class StudentResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final UserService userService;

    // Constructor...

    public CourseStatusChangeResponse changeCourseStatus(Long courseId, Integer action) {
        CourseStatusChangeResponse response = new CourseStatusChangeResponse();

        try {
            // Fetch the course by courseId
            Courses course = userService.findCourseById(courseId);

            if (course != null) {
                // Update the course status based on the action
                if (action == 1) {
                    course.setActive(1);
                } else if (action == 0) {
                    course.setActive(0);
                }

                // Perform the update in the service layer
                RequestResponse requestResponse = userService.updateCourseStatus(course);

                // Set the response based on the result of the update
                if (requestResponse.getResponseCode() == 0) {
                    response.setSuccess(true);
                    response.setMessage("Course status successfully changed");
                } else {
                    response.setSuccess(false);
                    response.setMessage(requestResponse.getMessage());
                }
            } else {
                response.setSuccess(false);
                response.setMessage("Course not found");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("An error occurred while changing course status");
            // Log the exception or handle it as needed
        }

        return response;
    }
}
