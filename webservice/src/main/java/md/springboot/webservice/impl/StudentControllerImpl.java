package md.springboot.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.StudentBusiness;
import md.springboot.webservice.StudentController;
import md.springboot.webservice.converter.StudentViewConverter;
import md.springboot.webservice.view.StudentView;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * Created by veladii on 30.08.2018
 */
@Controller
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentBusiness business;
    private final StudentViewConverter converter;

    @Override
    public Response retrieve() {
        return Response.ok().entity(business.retrieve()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList())).build();
    }

    @Override
    public Response retrieveById(Long id) {
        return Response.ok()
                .entity(business.retrieveById(id).map(converter::convert))
                .build();
    }

    @Override
    public Response create(StudentView view) {
        return Response.ok()
                .entity(business.create(converter.reverse().convert(view)))
                .build();
    }
}
