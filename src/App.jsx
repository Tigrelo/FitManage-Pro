import React from 'react';
import { Dumbbell, ChevronRight, Star, Flame, Target, Trophy } from 'lucide-react';

export default function App() {
    return (
        // "bg-background" aqui vai usar o oklch(0.145 0 0) que está no seu CSS dark
        <div className="min-h-screen bg-background text-foreground font-sans selection:bg-primary/30">

            {/* HEADER / NAV */}
            <header className="fixed top-0 w-full z-50 bg-background/80 backdrop-blur-md border-b border-border">
                <div className="max-w-7xl mx-auto px-6 h-20 flex justify-between items-center">
                    <div className="flex items-center gap-3 font-black text-2xl italic tracking-tighter">
                        <div className="bg-blue-600 p-1.5 rounded-lg shadow-lg">
                            <Dumbbell size={24} className="text-white" />
                        </div>
                        FITMANAGE <span className="text-blue-600">PRO</span>
                    </div>
                    <nav className="hidden md:flex items-center gap-8 text-sm font-bold uppercase tracking-widest">
                        <a href="#" className="text-foreground/70 hover:text-foreground">Início</a>
                        <a href="#" className="text-foreground/70 hover:text-foreground">Aulas</a>
                        <button className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2.5 rounded-full font-bold transition-all">
                            Área do Aluno
                        </button>
                    </nav>
                </div>
            </header>

            {/* HERO SECTION */}
            <section className="relative h-screen flex items-center justify-center pt-20 overflow-hidden">
                <img
                    src="/assets/1.jpg"
                    alt="Hero"
                    className="absolute inset-0 w-full h-full object-cover opacity-30 grayscale"
                />
                <div className="absolute inset-0 bg-gradient-to-t from-background via-transparent to-background/50" />

                <div className="relative z-10 text-center px-6 max-w-5xl">
                    <h1 className="text-7xl md:text-9xl font-black uppercase tracking-tighter leading-[0.8] mb-8">
                        FOCO NA <br /> <span className="text-blue-600 font-outline">VITÓRIA</span>
                    </h1>
                    <p className="text-xl text-muted-foreground max-w-2xl mx-auto mb-10 font-medium">
                        Treinamento de alta performance para quem não aceita menos que o topo.
                    </p>
                    <div className="flex gap-4 justify-center">
                        <button className="bg-blue-600 text-white px-10 py-5 rounded-2xl font-black uppercase tracking-widest shadow-xl shadow-blue-500/20 hover:scale-105 transition-all">
                            Matricule-se
                        </button>
                    </div>
                </div>
            </section>

            {/* AULAS SECTION */}
            <section className="py-32 px-6 max-w-7xl mx-auto">
                <h2 className="text-4xl font-black uppercase mb-16 text-left border-l-8 border-blue-600 pl-6">
                    Modalidades
                </h2>

                <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
                    {/* Card 1 - Boxe */}
                    <div className="group bg-card border border-border rounded-[2.5rem] p-4 hover:border-blue-500/50 transition-all">
                        <div className="h-72 rounded-[2rem] overflow-hidden mb-6">
                            <img src="/assets/3.jpg" className="w-full h-full object-cover grayscale group-hover:grayscale-0 transition-all duration-500" />
                        </div>
                        <h3 className="text-2xl font-bold px-4">Fight Boxe</h3>
                        <p className="text-muted-foreground p-4 text-sm">Técnica, força e disciplina em cada round.</p>
                    </div>

                    {/* Card 2 - CrossFit */}
                    <div className="group bg-card border border-border rounded-[2.5rem] p-4 hover:border-blue-500/50 transition-all">
                        <div className="h-72 rounded-[2rem] overflow-hidden mb-6">
                            <img src="/assets/6.jpg" className="w-full h-full object-cover grayscale group-hover:grayscale-0 transition-all duration-500" />
                        </div>
                        <h3 className="text-2xl font-bold px-4">Cross Training</h3>
                        <p className="text-muted-foreground p-4 text-sm">Supere seus limites com treinos explosivos.</p>
                    </div>

                    {/* Card 3 - Musculação */}
                    <div className="group bg-card border border-border rounded-[2.5rem] p-4 hover:border-blue-500/50 transition-all">
                        <div className="h-72 rounded-[2rem] overflow-hidden mb-6">
                            <img src="/assets/2.jpg" className="w-full h-full object-cover grayscale group-hover:grayscale-0 transition-all duration-500" />
                        </div>
                        <h3 className="text-2xl font-bold px-4">Bodybuilding</h3>
                        <p className="text-muted-foreground p-4 text-sm">Construa sua melhor versão com suporte de elite.</p>
                    </div>
                </div>
            </section>

            <footer className="py-12 border-t border-border text-center text-muted-foreground text-xs font-bold tracking-[0.4em] uppercase">
                FitManage Pro • Powered by Isaac
            </footer>
        </div>
    );
}