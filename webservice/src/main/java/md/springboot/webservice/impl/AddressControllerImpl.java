package md.springboot.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.AddressBusiness;
import md.springboot.webservice.AddressController;
import md.springboot.webservice.converter.AddressViewConverter;
import md.springboot.webservice.view.AddressView;
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

    @Override
    public Response retrieveById(Long id) {
        return Response.ok()
                .entity(business.retrieveById(id).map(converter::convert))
                .build();
    }

    @Override
    public Response create(AddressView view) {
        return Response.status(Response.Status.CREATED)
                .entity(business.create(converter.reverse().convert(view)))
                .build();
    }

    @Override
    public Response edit(Long id, AddressView view) {
        return Response.ok()
                .entity(business.edit(id, converter.reverse().convert(view)))
                .build();
    }
}
