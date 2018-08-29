package md.springboot.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.AddressBusiness;
import md.springboot.webservice.AddressController;
import md.springboot.webservice.converter.AddressViewConverter;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * Created by veladii on 29.08.2018
 */
@Controller
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {

    private final AddressBusiness business;
    private final AddressViewConverter converter;

    @Override
    public Response retrieve() {
        return Response.ok().entity(business.retrieve()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList())).build();
    }
}
