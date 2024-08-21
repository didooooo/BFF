package com.tinqinacademy.bff.core.processors.comments;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.leaveAComment.LeaveACommentInputBff;
import com.tinqinacademy.bff.api.operations.leaveAComment.LeaveACommentOperation;
import com.tinqinacademy.bff.api.operations.leaveAComment.LeaveACommentOutputBff;
import com.tinqinacademy.comments.api.operations.leaveAComment.LeaveACommentInput;
import com.tinqinacademy.comments.api.operations.leaveAComment.LeaveACommentOutput;
import com.tinqinacademy.comments.restexport.RestExportComments;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LeaveACommentProcessor implements LeaveACommentOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportComments restExportComments;

    public LeaveACommentProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportComments restExportComments) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportComments = restExportComments;
    }

    @Override
    public Either<Errors, LeaveACommentOutputBff> process(LeaveACommentInputBff input) {
        return Try.of(() -> {
                    LeaveACommentInput convert = conversionService.convert(input, LeaveACommentInput.class);
                    LeaveACommentOutput leaveACommentOutput = restExportComments.leaveACommentOutput(input.getRoomId(), convert);
                    return conversionService.convert(leaveACommentOutput, LeaveACommentOutputBff.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
