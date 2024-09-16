package br.com.henrique.placeservices.web;

import br.com.henrique.placeservices.api.PlaceResponse;
import br.com.henrique.placeservices.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
