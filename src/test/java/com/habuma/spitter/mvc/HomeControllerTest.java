package com.habuma.spitter.mvc;
import com.habuma.spitter.com.habuma.spitter.mvc.HomeController;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.junit.Test;


import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

/**
 * User: aeg
 * Date: 15/07/26
 * Time: 2:11
 */
public class HomeControllerTest {
    //private static final Integer DEFAULT_SPITTLES_PER_PAGE = 50;

    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles =
                asList(new Spittle(), new Spittle(), new Spittle());
        SpitterService spitterService = mock(SpitterService.class);


        when(spitterService.getLast50Spittles()).
                thenReturn(expectedSpittles);

        HomeController controller =
                new HomeController(spitterService);
        HashMap<String, Object> model =  new HashMap<String, Object>();
        controller.showHomePage(model);

        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService).getLast50Spittles();
    }
}
