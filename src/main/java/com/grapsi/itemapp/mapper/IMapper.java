package com.grapsi.itemapp.mapper;

public interface IMapper<I, O> {
    //Mapear los datos de entrada a Task para ser guardados en la BD

    public O map(I in);
}
