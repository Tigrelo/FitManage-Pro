import { useState, useEffect } from 'react';
import api from './services/api';
import { Dumbbell, Plus, LayoutDashboard, ListFilter, Activity } from 'lucide-react';

function App() {
    const [exercicios, setExercicios] = useState([]);
    const [novoExercicio, setNovoExercicio] = useState({
        nome: '', grupoMuscular: '', series: '', repeticoes: '', carga: ''
    });

    useEffect(() => {
        fetchExercicios();
    }, []);

    const fetchExercicios = async () => {
        try {
            const response = await api.get('/exercicios');
            setExercicios(response.data);
        } catch (error) {
            console.error("Erro ao buscar dados do Java:", error);
        }
    };

    const handleSalvar = async (e) => {
        e.preventDefault();
        try {
            await api.post('/exercicios', novoExercicio);
            setNovoExercicio({ nome: '', grupoMuscular: '', series: '', repeticoes: '', carga: '' });
            fetchExercicios();
        } catch (error) {
            alert("Erro ao conectar com o Backend Java!");
        }
    };

    return (
        <div className="min-h-screen bg-gray-100 flex">
            {/* Sidebar Lateral */}
            <aside className="w-64 bg-slate-900 text-white p-6 hidden md:block">
                <div className="flex items-center gap-3 mb-10">
                    <Dumbbell className="text-blue-400" size={32} />
                    <h1 className="text-xl font-bold tracking-tight">FitManage <span className="text-blue-400">Pro</span></h1>
                </div>
                <nav className="space-y-4">
                    <a href="#" className="flex items-center gap-3 p-2 bg-blue-600 rounded-lg"><LayoutDashboard size={20}/> Dashboard</a>
                    <a href="#" className="flex items-center gap-3 p-2 text-gray-400 hover:text-white transition"><Activity size={20}/> Meus Treinos</a>
                </nav>
            </aside>

            {/* Conteúdo Principal */}
            <main className="flex-1 p-8">
                <header className="flex justify-between items-center mb-8">
                    <h2 className="text-2xl font-semibold text-gray-800">Painel de Exercícios</h2>
                    <div className="text-sm text-gray-500">Node 21 + React 19 + Tailwind</div>
                </header>

                <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
                    {/* Formulário de Cadastro */}
                    <section className="bg-white p-6 rounded-xl shadow-sm border border-gray-200">
                        <h3 className="flex items-center gap-2 font-bold mb-6 text-gray-700">
                            <Plus size={20} className="text-blue-600" /> Adicionar Treino
                        </h3>
                        <form onSubmit={handleSalvar} className="space-y-4">
                            <div>
                                <label className="block text-xs font-medium text-gray-500 mb-1 uppercase">Nome do Exercício</label>
                                <input className="w-full p-2 border rounded-md focus:ring-2 focus:ring-blue-500 outline-none"
                                       value={novoExercicio.nome} onChange={e => setNovoExercicio({...novoExercicio, nome: e.target.value})} required />
                            </div>
                            <div>
                                <label className="block text-xs font-medium text-gray-500 mb-1 uppercase">Grupo Muscular</label>
                                <select className="w-full p-2 border rounded-md bg-white"
                                        value={novoExercicio.grupoMuscular} onChange={e => setNovoExercicio({...novoExercicio, grupoMuscular: e.target.value})} required>
                                    <option value="">Selecione...</option>
                                    <option value="Peito">Peito</option>
                                    <option value="Costas">Costas</option>
                                    <option value="Pernas">Pernas</option>
                                    <option value="Braços">Braços/Ombros</option>
                                </select>
                            </div>
                            <div className="grid grid-cols-3 gap-2">
                                <input type="number" placeholder="Séries" className="p-2 border rounded-md"
                                       value={novoExercicio.series} onChange={e => setNovoExercicio({...novoExercicio, series: e.target.value})} />
                                <input type="number" placeholder="Reps" className="p-2 border rounded-md"
                                       value={novoExercicio.repeticoes} onChange={e => setNovoExercicio({...novoExercicio, repeticoes: e.target.value})} />
                                <input type="number" placeholder="Kg" className="p-2 border rounded-md"
                                       value={novoExercicio.carga} onChange={e => setNovoExercicio({...novoExercicio, carga: e.target.value})} />
                            </div>
                            <button className="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 rounded-lg transition shadow-md">
                                Cadastrar Exercício
                            </button>
                        </form>
                    </section>

                    {/* Listagem de Exercícios */}
                    <section className="lg:col-span-2 bg-white p-6 rounded-xl shadow-sm border border-gray-200">
                        <h3 className="flex items-center gap-2 font-bold mb-6 text-gray-700">
                            <ListFilter size={20} className="text-blue-600" /> Lista de Treinos Atual
                        </h3>
                        <div className="overflow-x-auto">
                            <table className="w-full text-left">
                                <thead>
                                <tr className="border-b text-gray-400 text-sm">
                                    <th className="pb-3 font-medium">Exercício</th>
                                    <th className="pb-3 font-medium">Grupo</th>
                                    <th className="pb-3 font-medium text-center">Volume</th>
                                    <th className="pb-3 font-medium text-right">Carga</th>
                                </tr>
                                </thead>
                                <tbody className="divide-y">
                                {exercicios.map(ex => (
                                    <tr key={ex.id} className="hover:bg-gray-50 transition">
                                        <td className="py-4 font-semibold text-gray-800">{ex.nome}</td>
                                        <td className="py-4 text-gray-600"><span className="bg-blue-50 text-blue-700 px-2 py-1 rounded text-xs">{ex.grupoMuscular}</span></td>
                                        <td className="py-4 text-center text-gray-600">{ex.series} x {ex.repeticoes}</td>
                                        <td className="py-4 text-right font-mono font-bold text-blue-600">{ex.carga} kg</td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                            {exercicios.length === 0 && (
                                <div className="text-center py-10 text-gray-400">Nenhum exercício cadastrado ainda.</div>
                            )}
                        </div>
                    </section>
                </div>
            </main>
        </div>
    );
}

export default App;