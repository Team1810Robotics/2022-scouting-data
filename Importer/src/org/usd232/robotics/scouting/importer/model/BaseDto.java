package org.usd232.robotics.scouting.importer.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base class for DTOs that want to use reflection for basic methods.
 */
public abstract class BaseDto {
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode( this );
    }

    @Override
    public boolean equals( Object obj ) {
        return EqualsBuilder.reflectionEquals( this, obj );
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString( this );
    }
}
