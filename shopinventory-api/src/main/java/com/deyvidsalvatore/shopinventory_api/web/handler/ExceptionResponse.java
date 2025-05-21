package com.deyvidsalvatore.shopinventory_api.web.handler;

import java.util.Date;

public record ExceptionResponse(
		Date timestamp,
		String message,
		String details
) {}