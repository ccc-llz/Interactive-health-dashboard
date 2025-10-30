import DashboardCard from "../../components/DashboardCard";
import FFQForm from "../../components/Survey/FFQForm";

const Survey = () => {
  return (
    <div className="w-full h-full flex flex-col items-center justify-center p-4 pl-2">
      <DashboardCard className="text-md font-bold font-[Nunito] w-full max-w-7xl h-full" noHover={true}>
        <div className="max-h-full overflow-y-auto p-2">
        <FFQForm />
        </div>
      </DashboardCard>
    </div>
  );
};

export default Survey;
