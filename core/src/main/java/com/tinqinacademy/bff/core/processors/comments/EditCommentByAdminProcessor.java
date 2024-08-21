package com.tinqinacademy.bff.core.processors.comments;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.editCommentByAdmin.EditCommentsByAdminInputBff;
import com.tinqinacademy.bff.api.operations.editCommentByAdmin.EditCommentsByAdminOperation;
import com.tinqinacademy.bff.api.operations.editCommentByAdmin.EditCommentsByAdminOutputBff;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentInputBff;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentOutputBff;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentsOperation;
import com.tinqinacademy.comments.api.operations.editCommentByAdmin.EditCommentsByAdmin;
import com.tinqinacademy.comments.api.operations.editCommentByAdmin.EditCommentsByAdminInput;
import com.tinqinacademy.comments.api.operations.editCommentByAdmin.EditCommentsByAdminOutput;
import com.tinqinacademy.comments.restexport.RestExportComments;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EditCommentByAdminProcessor implements EditCommentsByAdminOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportComments restExportComments;

    public EditCommentByAdminProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportComments restExportComments) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportComments = restExportComments;
    }

    @Override
    public Either<Errors, EditCommentsByAdminOutputBff> process(EditCommentsByAdminInputBff input) {
        return Try.of(()->{
                    EditCommentsByAdminInput convert = conversionService.convert(input, EditCommentsByAdminInput.class);
                    EditCommentsByAdminOutput editCommentsByAdminOutput = restExportComments.editCommentsByAdminOutput(input.getCommentId(), convert);
                    return conversionService.convert(editCommentsByAdminOutput, EditCommentsByAdminOutputBff.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
