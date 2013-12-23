package com.springapp4.mvc.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import static com.springapp4.mvc.model.Constants.*;

/**
 * Created by josh on 12/22/13.
 */
@Entity
@Table(appliesTo = "metric_type")
public class MetricType {

    private String name;
    private METRIC_VALUE_TYPE value_type;
    private int precision = 0;
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public METRIC_VALUE_TYPE getValue_type() {
        return value_type;
    }

    public void setValue_type(METRIC_VALUE_TYPE value_type) {
        this.value_type = value_type;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

}
