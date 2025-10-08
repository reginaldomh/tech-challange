package com.fiapchallenge.garage.application.servicetype.command;

import java.math.BigDecimal;

public record CreateServiceTypeCommand(
        String description,
        BigDecimal value
) {
}
