package md.springboot.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 30.08.2018
 */
@Setter
@Getter
@NoArgsConstructor
public class StudentView implements Serializable {

    private static final long serialVersionUID = 5471970790681328541L;

    private Long id;

    private String name;

    private AddressView addressView;
}
