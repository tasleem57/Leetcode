class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        vector<pair<int, int>> projects(n);
        for (int i = 0; i < n; i++) {
            projects[i] = {capital[i], profits[i]};
        }
        //We sort the projects by their minimum capital required in ascending order because we want to consider the projects that we can afford with our current capital. By iterating over the sorted projects, we can ensure that we only consider the projects that have a minimum capital requirement less than or equal to our current capital.
        sort(projects.begin(), projects.end());
        int i = 0;
        priority_queue<int> maximizeCapital;
        while (k--) {
          
            while (i < n && projects[i].first <= w) {
                maximizeCapital.push(projects[i].second);
                i++;
            }
            if (maximizeCapital.empty())
                break;
            w += maximizeCapital.top();
            maximizeCapital.pop();
        }
        return w;
    }
};
