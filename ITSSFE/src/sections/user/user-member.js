const { parseISO, add } = require("date-fns");
import { Card, CardHeader, Divider, useMediaQuery } from "@mui/material";
import { PropertyList } from "src/components/property-list";
import { PropertyListItem } from "src/components/property-list-item";

export const UserMember = ({ register }) => {
  const mdUp = useMediaQuery((theme) => theme.breakpoints.up("md"));
  const align = mdUp ? "horizontal" : "vertical";

  const date = parseISO(register.created_at);
  const newDate = add(date, { days: 30 });

  const expirationDate = newDate.toISOString().slice(0, 10);

  return (
    <Card>
      <CardHeader title="Member" />
      <PropertyList>
        {(register && (
          <>
            <PropertyListItem align={align} divider label="Member Card" value={register.id} />
            <PropertyListItem
              align={align}
              divider
              label="Package"
              value={register.my_package_name}
            />
            <PropertyListItem
              align={align}
              divider
              label="Registration Date"
              value={register.created_at.slice(0, 10)}
            />
            <PropertyListItem
              align={align}
              divider
              label="Expiration Date"
              value={expirationDate}
            />
            <PropertyListItem align={align} divider label="Trainer" value={register.trainer_name} />
            <PropertyListItem
              align={align}
              divider
              label="Registered by"
              value={register.register_by_name}
            />
          </>
        )) || (
          <>
            <PropertyListItem align={align} divider label="Member Card" value="" />
            <PropertyListItem align={align} divider label="Package" value="" />
            <PropertyListItem align={align} divider label="Registration Date" value="" />
            <PropertyListItem align={align} divider label="Expiration Date" value="" />
            <PropertyListItem align={align} divider label="Trainer" value="" />
            <PropertyListItem align={align} divider label="Registered by" value="" />
          </>
        )}
      </PropertyList>
      <Divider />
    </Card>
  );
};
