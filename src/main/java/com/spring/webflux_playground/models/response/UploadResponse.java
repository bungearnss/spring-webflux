package com.spring.webflux_playground.models.response;

import java.util.UUID;

public record UploadResponse(UUID confirmationId,
                             Long productsCount) {
}
