package com.softtech.webapp.app.gen.service;

import com.softtech.webapp.app.gen.entity.BaseEntity;
import com.softtech.webapp.app.gen.enums.ErrorMessage;
import com.softtech.webapp.app.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E, Long>> {
    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E entity, boolean isUpdate){

        setAdditionalFields(entity, isUpdate);
        entity = dao.save(entity);

        return entity;
    }

    public void delete(E entity){
        dao.delete(entity);
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }

    public D getDao() {
        return dao;
    }

    private void setAdditionalFields(E entity, boolean isUpdate) {

        LocalDateTime dateNow = LocalDateTime.now();
        Date date = java.sql.Date.valueOf(String.valueOf(dateNow));

        if(isUpdate) {
            entity.getBaseAdditionalFields().setUpdateDate(date);
            entity.getBaseAdditionalFields().setUpdatedBy(1L);
        }
        else {
            entity.getBaseAdditionalFields().setCreateDate(date);
            entity.getBaseAdditionalFields().setCreatedBy(1L);
        }
    }

    public E getByIdWithControl(Long id, boolean isRelation) {
        Optional<E> entityOptional = findById(id);

        E entity;
        if (entityOptional.isPresent()){
            entity = entityOptional.get();
        }

        else {
            if(isRelation)
                throw new ItemNotFoundException(ErrorMessage.RELATION_NOT_FOUND);
            else
                throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }
}
