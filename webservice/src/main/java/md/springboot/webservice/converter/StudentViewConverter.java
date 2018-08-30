package md.springboot.webservice.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.springboot.business.dto.Student;
import md.springboot.webservice.view.StudentView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 30.08.2018
 */
@Component
@RequiredArgsConstructor
public class StudentViewConverter extends Converter<Student, StudentView> {

    private final AddressViewConverter addressViewConverter;

    @Override
    protected StudentView doForward(Student dto) {
        StudentView view = new StudentView();
        view.setId(dto.getId());
        view.setName(dto.getName());
        view.setAddressView(addressViewConverter.convert(dto.getAddress()));
        return view;
    }

    @Override
    protected Student doBackward(StudentView view) {
        Student dto = new Student();
        dto.setId(view.getId());
        dto.setName(view.getName());
        dto.setAddress(addressViewConverter.reverse().convert(view.getAddressView()));
        return dto;
    }
}
