import React, { useState } from "react";
import NextLink from "next/link";
import PropTypes from "prop-types";
import { Button, Card, CardContent, CardMedia, Link, Stack, Typography, Dialog, DialogTitle, DialogContent, DialogActions } from "@mui/material";
import { paths } from "src/paths";

export const RoomCard = (props) => {
  const { room, onClickEdit, onClickDelete } = props;
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleDelete = () => {
    onClickDelete(room.id);
    handleClose();
  };

  return (
    <>
      <Card variant="outlined">
        <CardMedia
          image={"/assets/rooms/room-2.png"}
          component={NextLink}
          href={paths.gyms.details(room.id || 1)}
          sx={{ height: 180 }}
        />
        <CardContent>
          <Link
            color="text.primary"
            underline="none"
            variant="subtitle1"
            component={NextLink}
            href={paths.gyms.details(room.id || 1)}
          >
            {room.name}
          </Link>
          <Typography color="text.secondary" sx={{ mt: 1 }} variant="body2">
            {room.address}
          </Typography>
          <Typography color="text.secondary" sx={{ mt: 1 }} variant="body2">
            {`Acreage: ${room.acreage} m²`}
          </Typography>
        </CardContent>
        <Stack
          direction={{
            xs: "column",
            sm: "row",
          }}
          flexWrap="wrap"
          spacing={3}
          sx={{ p: 3 }}
        >
          <Button
            variant="contained"
            onClick={() => {
              onClickEdit(room);
            }}
          >
            Edit
          </Button>
          <Button
            color="error"
            variant="contained"
            onClick={handleClickOpen}
          >
            Delete
          </Button>
        </Stack>
      </Card>

      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">{"Confirm Delete"}</DialogTitle>
        <DialogContent>
          <Typography id="alert-dialog-description">
            Are you sure you want to delete this room?
          </Typography>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            No
          </Button>
          <Button onClick={handleDelete} color="primary" autoFocus>
            Yes
          </Button>
        </DialogActions>
      </Dialog>
    </>
  );
};

RoomCard.propTypes = {
  room: PropTypes.object.isRequired,
  onClickEdit: PropTypes.func,
  onClickDelete: PropTypes.func,
};
